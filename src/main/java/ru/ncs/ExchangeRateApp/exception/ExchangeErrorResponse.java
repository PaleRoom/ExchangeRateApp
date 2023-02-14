package ru.ncs.ExchangeRateApp.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Getter
@Setter
@Value
@AllArgsConstructor
public class ExchangeErrorResponse {
     String message;
     String exceptionName;
     long timestamp;

}
