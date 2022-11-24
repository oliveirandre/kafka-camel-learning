package com.example.dequeuer.route;

import com.example.dequeuer.entity.Book;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class KafkaReceiverRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("kafka:BOOK_TOPIC")
                .unmarshal().json(JsonLibrary.Jackson, Book.class)
                .to("log:log")
                .to("jpa:com.example.dequeuer.entity.Book");
    }
}
