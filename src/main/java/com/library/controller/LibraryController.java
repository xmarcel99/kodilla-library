package com.library.controller;

import com.library.dbservice.DbService;
import com.library.dbservice.NoBookException;
import com.library.domain.Book;
import com.library.domain.Dto.BookDto;
import com.library.domain.Dto.ReaderDto;
import com.library.domain.Dto.TitleDto;
import com.library.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("v2/library")
public class LibraryController {
    @Autowired
    DbService dbService;
    @Autowired
    Mapper mapper;

    @RequestMapping(method = RequestMethod.POST, value = "addReader")
    public void addReader(@RequestBody ReaderDto readerDto) {
        dbService.addReader(mapper.mapToReader(readerDto));
    }

    @RequestMapping(method = RequestMethod.POST,value = "addTitle")
    public void addTitle(@RequestBody TitleDto titleDto) {
        dbService.addTitle(mapper.mapToTitle(titleDto));
    }

    @RequestMapping(method = RequestMethod.POST,value = "addBook")
    public void addBook(@RequestBody BookDto bookDto) {
        dbService.addBook(mapper.mapToBook(bookDto));
    }

    @RequestMapping(method = RequestMethod.PUT,value = "updateBookStatus")
    public Book updateBookStatus(@RequestParam int bookId,String status) throws NoBookException {
        Book book = dbService.findBookById(bookId).orElseThrow(NoBookException::new);
        book.setStatus(status);
        return book;
    }

    @RequestMapping(method = RequestMethod.GET,value = "getBookCountByTitle")
    public int getBookCountByTitle(@RequestParam int titleId) {
        return dbService.getBookCountById(titleId);
    }


}
