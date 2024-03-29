package com.library.domain.dto;

import com.library.domain.Rentals;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
@AllArgsConstructor
@Getter
public class ReaderDto {

    private int readerId;

    private String firstname;

    private String lastname;

    private LocalDate singUpDate;

    private List<Rentals> rentalBook;

}
