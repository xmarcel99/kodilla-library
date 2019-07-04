package com.library.domain.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class RentalsDTO {

    private int rentalId;

    private int bookId;

    private int readerId;

    private LocalDate rentDate;

    private LocalDate giveBackDate;
}
