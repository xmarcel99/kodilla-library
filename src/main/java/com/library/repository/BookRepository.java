package com.library.repository;

import com.library.domain.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends CrudRepository<Book,Integer> {
    @Query
    int getBookCountByTitle(@Param(value = "titleId") int titleId);
}
