package com.library.domain.Dto;

import com.library.domain.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class TitleDto {
    private int titleId;
    private String bookTitle;
    private String author;
    private int publicationYear;
    private List<Book> books;
}
