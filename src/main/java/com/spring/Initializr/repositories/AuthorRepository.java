package com.spring.Initializr.repositories;

import com.spring.Initializr.domain.Author;
import org.springframework.data.repository.CrudRepository;


public interface AuthorRepository extends CrudRepository <Author, Long> {


}
