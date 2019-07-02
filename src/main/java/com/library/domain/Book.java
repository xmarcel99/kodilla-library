package com.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Book {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "book_id",unique = true)
    private int bookId;
    @Setter
    @ManyToOne
    @JoinColumn(name = "book_title_id")
    private Title titleId;
    private String status;

    public Book(Title titleId, String status) {
        this.titleId = titleId;
        this.status = status;
    }
}
