package se.sbab.sbabbe.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Collections;

import org.springframework.stereotype.Service;

import se.sbab.sbabbe.DTOs.BaseResponse;
import se.sbab.sbabbe.DTOs.LineStop;
import se.sbab.sbabbe.DTOs.StopPoint;
import se.sbab.sbabbe.DTOs.TopLine;
import se.sbab.sbabbe.Repositories.IStopsAndLinesRepository;

@Service
public class LineAndStopServiceImpl implements ILineAndStopService {

    private final IStopsAndLinesRepository repository;
    private final Integer ResponseLimit = 10;

    public LineAndStopServiceImpl(IStopsAndLinesRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TopLine> getTop10Lines() {
        // Get all line nr -> stop nrs connections
        BaseResponse<LineStop> lineStops = repository.getLineStops();
        List<TopLine> topLines = new ArrayList<TopLine>();

        // Get all stop names
        List<StopPoint> distictStops = getDistinctStops();

        // Loop every line -> stop connection
        for (var lineStop : lineStops.responseData.result) {
            // Get the corresponding StopPoint for this stop nr
            Optional<StopPoint> stop = getStopPointForLineNumber(
                distictStops, 
                lineStop.journeyPatternPointNumber
            );

            // Ignore missing stops
            if (!stop.isPresent()) {
                continue;
            }
            String stopName = stop.get().stopPointName;
            if (!lineNumberAlreadyInList(topLines, lineStop.lineNumber)) {
                // Create a new top line entry for the current line nr
                topLines.add(new TopLine(lineStop.lineNumber));
            }
            // Find the top line entry for this line nr and add the stop
            TopLine matchedLine = getTopLineWithLineNumber(topLines, lineStop.lineNumber);
            topLines.get(topLines.indexOf(matchedLine)).stopNames.add(stopName);
        }

        // Sort by stops array size
        Collections.sort(topLines);
        // Limit nr of items
        return topLines.subList(0, ResponseLimit - 1);
    }

    private TopLine getTopLineWithLineNumber(List<TopLine> list, Integer lineNumber) {
        return list.stream()
                    .filter(l -> l.lineNumber.equals(lineNumber))
                    .findFirst()
                    .get();
    }

    private Boolean lineNumberAlreadyInList(List<TopLine> list, Integer lineNumber) {
        return list.stream()
            .anyMatch(l -> l.lineNumber.equals(lineNumber));
    }

    private Optional<StopPoint> getStopPointForLineNumber(List<StopPoint> stops, Integer lineNumber) {
        return stops.stream()
                .filter(s -> s.stopPointNumber.equals(lineNumber))
                .findFirst();
    }

    private List<StopPoint> getDistinctStops() {
        BaseResponse<StopPoint> stops = repository.getAllStops();
        return stops.responseData.result.stream()
            // Remove duplicates created by DirectionCode
            .distinct()
            .toList();
    }
    
}
