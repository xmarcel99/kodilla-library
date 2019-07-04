package com.library.mapper;

import com.library.dbservice.DbService;
import com.library.domain.Book;
import com.library.domain.dto.BookDTO;
import com.library.domain.NoTitleException;
import com.library.domain.Title;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    @Autowired
    DbService dbService;

    public Book mapToBookFromBookJson(BookDTO bookDTO) throws NoTitleException {
        Title title = dbService.findTitleByid(bookDTO.getTitleId()).orElseThrow(NoTitleException::new);
        return  new Book(bookDTO.getBookId(),title, bookDTO.getStatus());
    }
}
