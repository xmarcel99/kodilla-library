package com.library.domain.Dto;

import com.library.domain.Title;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BookDto {
    private int bookId;
    private Title titleId;
    private String status;
}
