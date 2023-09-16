package se.sbab.sbabbe.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LineStop {
    @JsonProperty("LineNumber")
    public Integer lineNumber;
    @JsonProperty("JourneyPatternPointNumber")
    public Integer journeyPatternPointNumber;
}
