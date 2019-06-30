package com.library.domain.Dto;

import com.library.domain.Title;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BookDto {
    private int bookId;
    private Title titleId;
    private String status;
}
