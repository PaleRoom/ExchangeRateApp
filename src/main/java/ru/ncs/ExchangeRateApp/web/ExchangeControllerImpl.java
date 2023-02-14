package ru.ncs.ExchangeRateApp.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ncs.ExchangeRateApp.exception.ServiceUnavailableException;
import ru.ncs.ExchangeRateApp.response.ExchangeResponse;

@RestController
@RequestMapping("/exchangerate")
@RequiredArgsConstructor
public class ExchangeControllerImpl implements ExchangeController {

    @Value("${app.exchange.enabled}")
    boolean enabled;

    private final ExchangeResponse exchangeResponse;
    @Override
    @GetMapping
    public ExchangeResponse getExchangeRate() {
        if (enabled)
            return exchangeResponse.takeRate();
        else throw new ServiceUnavailableException();
    }
}
