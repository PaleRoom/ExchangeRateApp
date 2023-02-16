package ru.ncs.ExchangeRateApp.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.ncs.ExchangeRateApp.producer.Producer;
import ru.ncs.ExchangeRateApp.response.ExchangeResponse;

@Service
@RequiredArgsConstructor
@Slf4j
public class Consumer {
    private final Producer producer;
    private final ExchangeResponse exchangeResponse;
    @KafkaListener(topics = "topic1", containerFactory = "kafkaListenerContainerFactoryString")
    public void listenGroupTopic1(String message) {
        log.info("Receive message {}", message);
        producer.sendMessage("ExchangeTopic2", 23, 24, exchangeResponse.takeRate(),2 );
    }

//    @KafkaListener(topics = "topic2", containerFactory = "kafkaListenerContainerFactoryMessage")
//    public void listenGroupTopic2(ConsumerRecord<String, Message> record) {
//        log.info("Receive message {}", record);
//    }
}
