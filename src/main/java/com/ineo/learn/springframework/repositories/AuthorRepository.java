package com.ineo.learn.springframework.repositories;

import com.ineo.learn.springframework.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
