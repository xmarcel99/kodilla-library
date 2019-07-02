package com.library.domain.Dto;

import com.library.domain.Book;
import com.library.domain.Reader;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
@AllArgsConstructor
@Getter
public class RentalsDto {
    private int rentalId;
    private Book bookId;
    private Reader readerId;
    private LocalDate rentDate;
    private LocalDate giveBackDate;
}
