package se.sbab.sbabbe.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.ArrayList;

public class TopLine implements Comparable<TopLine> {

    public TopLine(Integer lineNumber) {
        this.lineNumber = lineNumber;
        this.stopNames = new ArrayList<String>();
    }

    @JsonProperty("LineNumber")
    public Integer lineNumber;
    @JsonProperty("StopNames")
    public List<String> stopNames;
    
    @JsonProperty("NrOfStops")
    public Integer size() {
        return stopNames.size();
    }

    @Override
    public int compareTo(TopLine arg0) {
        // Order is important since we want to order large > small
        return arg0.size().compareTo(this.size());
    }
}
