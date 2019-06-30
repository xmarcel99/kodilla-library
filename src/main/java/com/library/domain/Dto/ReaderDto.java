package com.library.domain.Dto;

import com.library.domain.Rentals;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@AllArgsConstructor
public class ReaderDto {
    private int readerId;
    private String firstname;
    private String lastname;
    private LocalDate singUpDate;
    private List<Rentals> rentalBook;
}
