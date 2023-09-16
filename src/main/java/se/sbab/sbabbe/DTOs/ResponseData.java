package se.sbab.sbabbe.DTOs;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseData<T> {
    @JsonProperty("Version")
    public String version;
    @JsonProperty("Type")
    public String type;
    @JsonProperty("Result")
    public List<T> result;
}
