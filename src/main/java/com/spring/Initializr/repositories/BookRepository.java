package com.spring.Initializr.repositories;

import com.spring.Initializr.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository< Book, Long> {
}
