package com.library.domain.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BookJson {
    private int bookId;
    private int titleId;
    private String status;
}
