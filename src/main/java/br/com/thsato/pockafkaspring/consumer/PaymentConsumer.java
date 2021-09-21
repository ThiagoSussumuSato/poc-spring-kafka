package br.com.thsato.pockafkaspring.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PaymentConsumer {
    @KafkaListener(topics = "PAYMENT_ORDER", groupId = "${spring.kafka.consumer.group-id}")
    public void consumer(final ConsumerRecord consumerRecord) {
        log.info("[consumer] Payment Order Cunsumed");
        log.info("[consumer] key.......: " + consumerRecord.key());
        log.info("[consumer] headers...: " + consumerRecord.headers());
        log.info("[consumer] partition.: " + consumerRecord.partition());
        log.info("[consumer] value.....: " + consumerRecord.value());
    }
}
