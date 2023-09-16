package se.sbab.sbabbe.Repositories;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

import se.sbab.sbabbe.Clients.ApiClient;
import se.sbab.sbabbe.DTOs.BaseResponse;
import se.sbab.sbabbe.DTOs.LineStop;
import se.sbab.sbabbe.DTOs.StopPoint;

@Repository
public class StopsAndLinesRepository implements IStopsAndLinesRepository {

    // Read API_KEY from either config or env
    @Value("${API_KEY}")
    private String apiKey;
    private ApiClient apiClient;

    public StopsAndLinesRepository(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    @Override
    public BaseResponse<StopPoint> getAllStops() {
        WebClient client = apiClient.getApiClient();
        return client.get()
            .uri(builder -> builder
                .path("/Linedata.json")
                .queryParam("DefaultTransportModeCode", "BUS")
                .queryParam("model", "StopPoint")
                .queryParam("key", apiKey)
                .build())
            .retrieve()
            .bodyToMono(new ParameterizedTypeReference<BaseResponse<StopPoint>>() {})
            .block();
    }

    @Override
    public BaseResponse<LineStop> getLineStops() {
        WebClient client = apiClient.getApiClient();
        return client.get()
            .uri(builder -> builder
                .path("/Linedata.json")
                .queryParam("DefaultTransportModeCode", "BUS")
                .queryParam("model", "JourneyPatternPointOnLine")
                .queryParam("key", apiKey)
                .build())
            .retrieve()
            .bodyToMono(new ParameterizedTypeReference<BaseResponse<LineStop>>() {})
            .block();
    }
    
}
