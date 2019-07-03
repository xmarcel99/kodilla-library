package com.library.domain.Dto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class RentalsJson {
    private int rentalId;
    private int bookId;
    private int readerId;
    private LocalDate rentDate;
    private LocalDate giveBackDate;
}
