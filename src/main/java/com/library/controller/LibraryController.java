package com.library.controller;

import com.library.dbservice.DbService;
import com.library.dbservice.NoBookException;
import com.library.dbservice.NoReaderException;
import com.library.domain.Book;
import com.library.domain.Dto.*;
import com.library.domain.NoTitleException;
import com.library.domain.Reader;
import com.library.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public void addBook(@RequestBody BookJson bookJson) {
        try {
            Book book = mapper.mapToBookFromBookJson(bookJson);
            dbService.addBook(book);
        } catch (NoTitleException e) {
            System.out.println(e.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.PUT,value = "updateBookStatus")
    public void updateBookStatus(@RequestParam int bookId,@RequestParam String status) throws NoBookException {
        Book book = dbService.findBookById(bookId).orElseThrow(NoBookException::new);
        book.setStatus(status);
        dbService.addBook(book);
    }

    @RequestMapping(method = RequestMethod.GET,value = "getBookCountByTitle")
    public int getBookCountByTitle(@RequestParam int titleId) {
        return dbService.getBookCountById(titleId);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "addRental")
    public void addRental(@RequestBody RentalsJson rentalsJson) {
        try {
            Reader reader = dbService.findReaderById(rentalsJson.getReaderId()).orElseThrow(NoReaderException::new);
            reader.getRentalBook().add((mapper.mapToRentalsFromRentalsJson(rentalsJson)));
            dbService.addReader(reader);
            dbService.addRentals(mapper.mapToRentalsFromRentalsJson(rentalsJson));
        } catch (NoBookException e) {
            System.out.println(e.getMessage());
        } catch (NoReaderException e) {
            System.out.println(e.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "deleteRental")
    public void deleteRental(@RequestParam int id) {
        dbService.deleteRental(id);
    }

}
