package se.sbab.sbabbe.Clients;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class ApiClient {
    
    public WebClient getApiClient() {
        final int size = 16 * 1024 * 1024;
        final ExchangeStrategies strategies = ExchangeStrategies.builder()
            .codecs(codecs -> codecs.defaultCodecs().maxInMemorySize(size))
            .build();
        return WebClient.builder()
            .baseUrl("https://api.sl.se/api2")
            .exchangeStrategies(strategies)
            .build();
        }

}
