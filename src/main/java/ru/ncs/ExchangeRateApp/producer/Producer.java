package ru.ncs.ExchangeRateApp.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.ncs.ExchangeRateApp.response.ExchangeResponse;

//@Service
@RequiredArgsConstructor
@Slf4j
public class Producer {
    private final KafkaTemplate<String, ExchangeResponse> kafkaTemplateMessage;
    private final ExchangeResponse exchangeResponse;

    public void sendMessage(String topic, int keyFrom, int keyTo, ExchangeResponse data, int count) {
        log.info("Start sending Exchanging Currency");

        for (int i = keyFrom; i < keyTo; ++i) {
            for (int j = 0; j < count; ++j) {
                kafkaTemplateMessage.send(topic, Integer.toString(i),
                        data);
                log.info("Exchanging Currency {}", data);
            }
        }

        log.info("complete Exchanging Currency send");
    }
}
