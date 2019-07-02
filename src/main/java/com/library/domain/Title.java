package com.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Title {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "title_id",unique = true)
    private int titleId;
    private String bookTitle;
    private String author;
    private int publicationYear;
    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "titleId"
    )
    private List<Book> books;

    public Title(String bookTitle, String author, int publicationYear, List<Book> books) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.publicationYear = publicationYear;
        this.books = books;
    }
}
