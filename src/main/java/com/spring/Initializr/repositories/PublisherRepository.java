package com.spring.Initializr.repositories;

import com.spring.Initializr.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
