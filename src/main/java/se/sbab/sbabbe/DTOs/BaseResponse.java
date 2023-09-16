package se.sbab.sbabbe.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseResponse<T> {
    @JsonProperty("StatusCode")
    public Integer statusCode;
    @JsonProperty("ResponseData")
    public ResponseData<T> responseData;
}
