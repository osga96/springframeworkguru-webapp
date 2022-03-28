package com.ineo.learn.springframework.repositories;

import com.ineo.learn.springframework.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
