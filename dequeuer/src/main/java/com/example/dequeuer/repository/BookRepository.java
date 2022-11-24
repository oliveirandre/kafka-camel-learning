package com.example.dequeuer.repository;

import com.example.dequeuer.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
}
