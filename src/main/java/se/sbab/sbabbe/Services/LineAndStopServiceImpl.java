package se.sbab.sbabbe.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import org.springframework.stereotype.Service;

import se.sbab.sbabbe.DTOs.BaseResponse;
import se.sbab.sbabbe.DTOs.LineStop;
import se.sbab.sbabbe.DTOs.StopPoint;
import se.sbab.sbabbe.DTOs.TopLine;
import se.sbab.sbabbe.Repositories.IStopsAndLinesRepository;

@Service
public class LineAndStopServiceImpl implements ILineAndStopService {

    private IStopsAndLinesRepository repository;

    public LineAndStopServiceImpl(IStopsAndLinesRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TopLine> getTop10Lines() {
        BaseResponse<StopPoint> stops = repository.getAllStops();
        List<StopPoint> distictStops = stops.responseData.result.stream()
            // Remove duplicates created by DirectionCode
            .distinct()
            .toList();

        BaseResponse<LineStop> lineStops = repository.getLineStops();
        List<TopLine> topLines = new ArrayList<TopLine>();

        for (var lineStop : lineStops.responseData.result) {
            var stop = distictStops.stream()
                .filter(s -> s.stopPointNumber.equals(lineStop.journeyPatternPointNumber))
                .findFirst();
            if (!stop.isPresent()) {
                continue;
            }
            var stopName = stop.get().stopPointName;
            if (!topLines.stream().anyMatch(l -> l.lineNumber.equals(lineStop.lineNumber))) {
                topLines.add(new TopLine(lineStop.lineNumber));
            }
            else {
                var matchedLine = topLines.stream()
                    .filter(l -> l.lineNumber.equals(lineStop.lineNumber))
                    .findFirst()
                    .get();
                topLines.get(topLines.indexOf(matchedLine)).stopNames.add(stopName);
            }
        }

        // Sort by lines array size, and limit to 10
        Collections.sort(topLines);
        return topLines.subList(0, 10);
            

        // Code below left as history for first attempt with only streams

        /*lineStops.responseData.result.stream()
            .forEach(ls -> {
                stopsPerLine.merge(ls.lineNumber, 
                    Arrays.asList(ls.journeyPatternPointNumber),
                    (oldVal, newVal) -> {
                        oldVal.add(ls.journeyPatternPointNumber);
                        return oldVal;
                    });
            });*/
        
        /*Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        // Calculate number of stops per line
        lineStops.responseData.result.stream()
            .forEach(ls -> counts.merge(ls.lineNumber, 1, Integer::sum));
        // Sort our hashmap
        Map<Integer, Integer> sortedCounts = counts.entrySet().stream()
            .sorted(Comparator.comparingInt(Map.Entry::getValue))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, 
                (k,v)->k, LinkedHashMap::new));
        sortedCounts.entrySet().stream()
            .limit(10)
            .map(e -> {
                String stopName = stops.responseData.result.stream()
                    .filter(s -> s.stopPointNumber.equals(e.))
            })*/
    }
    
}
