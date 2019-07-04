package com.library.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BookDTO {

    private int bookId;

    private int titleId;

    private String status;
}
