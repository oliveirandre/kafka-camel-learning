package com.example.queuer.controller;

import com.example.queuer.model.Book;
import com.example.queuer.service.SendService;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class SendController {
    private final SendService sendService;
    private final KafkaTemplate<String, Book> kafkaTemplate;

    public SendController(SendService sendService, KafkaTemplate<String, Book> kafkaTemplate) {
        this.sendService = sendService;
        this.kafkaTemplate = kafkaTemplate;
    }

    private static final String BOOK_TOPIC = "BOOK_TOPIC";

    @GetMapping("/send")
    public void sendName() throws IOException {
        sendService.send();
    }

    @PostMapping("/publish")
    public String publishMessage(@RequestBody Book book) throws InterruptedException {
        kafkaTemplate.send(BOOK_TOPIC, book);
        return "Published successfully";
    }

}
