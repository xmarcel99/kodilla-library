package com.library.mapper;

import com.library.dbservice.DbService;
import com.library.dbservice.NoBookException;
import com.library.dbservice.NoReaderException;
import com.library.domain.*;
import com.library.domain.Dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    @Autowired
    DbService dbService;
    public Rentals mapToRentalsFromRentalsJson(RentalsJson rentalsJson) throws NoBookException,NoReaderException {
        Book book = dbService.findBookById(rentalsJson.getBookId()).orElseThrow(NoBookException::new);
        Reader reader = dbService.findReaderById(rentalsJson.getReaderId()).orElseThrow(NoReaderException::new);
        return new Rentals(rentalsJson.getRentalId(),book,reader,rentalsJson.getRentDate(),rentalsJson.getGiveBackDate());
    }
    public Book mapToBookFromBookJson(BookJson bookJson) throws NoTitleException {
        Title title = dbService.findTitleByid(bookJson.getTitleId()).orElseThrow(NoTitleException::new);
        return  new Book(bookJson.getBookId(),title,bookJson.getStatus());
    }

    public Reader mapToReader(ReaderDto readerDto) {
        return new Reader(readerDto.getReaderId(), readerDto.getFirstname(), readerDto.getLastname(), readerDto.getSingUpDate(), readerDto.getRentalBook());
    }


    public Title mapToTitle(TitleDto titleDto) {
        return new Title(titleDto.getTitleId(), titleDto.getBookTitle(), titleDto.getAuthor(), titleDto.getPublicationYear(), titleDto.getBooks());
    }

}
