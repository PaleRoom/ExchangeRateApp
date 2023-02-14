package ru.ncs.ExchangeRateApp.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.jackson.Jacksonized;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;
import ru.ncs.ExchangeRateApp.model.ExchangeRate;


@Data
@Builder
@Component
@Jacksonized
@RequiredArgsConstructor

public class ExchangeResponse {

    private final HashMap<String, Double> exchangeRate;

    public ExchangeResponse takeRate() {
        ObjectMapper objectMapper = new ObjectMapper();
        HashMap<String, Double> rate;
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("ExchangeRate.json")) {

            File file = new File("tempExchangingCurrency.txt");
            FileUtils.copyInputStreamToFile(input, file);
            ExchangeRate rateResponse = objectMapper.readValue(file, ExchangeRate.class);
            file.delete();
            rate = rateResponse.getExchangeRate();

//

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ExchangeResponse.builder()
                .exchangeRate(rate)
                .build();

    }

}
