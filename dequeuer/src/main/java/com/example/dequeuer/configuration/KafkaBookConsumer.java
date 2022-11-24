package com.example.dequeuer.configuration;

import com.example.dequeuer.entity.Book;

//@Component
public class KafkaBookConsumer {

    //@KafkaListener(topics = "BOOK_TOPIC", groupId = "group_id")
    public void consume(Book book) {
        System.out.println(book.toString());
    }

}
