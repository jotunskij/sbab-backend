package se.sbab.sbabbe.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StopPoint {
    @JsonProperty("StopPointNumber")
    public Integer stopPointNumber;
    @JsonProperty("StopPointName")
    public String stopPointName;

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof StopPoint))
            return false;
        StopPoint arg0 = (StopPoint)o;
        return this.stopPointName.equals(arg0.stopPointName);
    }

    @Override
    public int hashCode() {
        return stopPointName.hashCode();
    }
}
