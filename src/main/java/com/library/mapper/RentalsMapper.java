package com.library.mapper;

import com.library.dbservice.DbService;
import com.library.dbservice.NoBookException;
import com.library.dbservice.NoReaderException;
import com.library.domain.Book;
import com.library.domain.dto.RentalsDTO;
import com.library.domain.Reader;
import com.library.domain.Rentals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RentalsMapper {

    @Autowired
    DbService dbService;

    public Rentals mapToRentalsFromRentalsJson(RentalsDTO rentalsDTO) throws NoBookException, NoReaderException {
        Book book = dbService.findBookById(rentalsDTO.getBookId()).orElseThrow(NoBookException::new);
        Reader reader = dbService.findReaderById(rentalsDTO.getReaderId()).orElseThrow(NoReaderException::new);
        return new Rentals(rentalsDTO.getRentalId(),book,reader, rentalsDTO.getRentDate(), rentalsDTO.getGiveBackDate());
    }
}
