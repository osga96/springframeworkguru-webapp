package com.ineo.learn.springframework.repositories;

import com.ineo.learn.springframework.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
