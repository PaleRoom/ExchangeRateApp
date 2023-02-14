package ru.ncs.ExchangeRateApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    private ResponseEntity<ExchangeErrorResponse> handleException(ServiceUnavailableException e) {
        ExchangeErrorResponse response = new ExchangeErrorResponse(
                e.getMessage(),
                e.getClass().getSimpleName(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.SERVICE_UNAVAILABLE); // 503
    }


}

