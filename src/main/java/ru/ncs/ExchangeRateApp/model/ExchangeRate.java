package ru.ncs.ExchangeRateApp.model;

import java.util.HashMap;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class ExchangeRate {
    private HashMap<String, Double> exchangeRate;
}
