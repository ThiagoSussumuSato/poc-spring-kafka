package br.com.thsato.pockafkaspring.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@Service
@Slf4j
public class PaymentProducer {

    private String paymentTopic = "PAYMENT_ORDER";

    private final KafkaTemplate<String, String> kafkaTemplate;

    public PaymentProducer(final KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(final @RequestBody String payment) {
        final String mensageKey = UUID.randomUUID().toString();
        kafkaTemplate.send(paymentTopic, mensageKey, payment);
        log.info("[producer] payment order enviado");
    }


}
