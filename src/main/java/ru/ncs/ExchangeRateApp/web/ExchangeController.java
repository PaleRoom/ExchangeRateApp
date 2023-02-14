package ru.ncs.ExchangeRateApp.web;

import org.springframework.web.bind.annotation.RequestMapping;
import ru.ncs.ExchangeRateApp.response.ExchangeResponse;

@RequestMapping("/default")
public interface ExchangeController {
    ExchangeResponse getExchangeRate();
}
