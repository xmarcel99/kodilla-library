package com.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Reader {

    @Id
    @GeneratedValue
    private int readerId;

    private String firstname;

    private String lastname;

    private LocalDate singUpDate;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "readerId"
    )
    private List<Rentals> rentalBook;

    public Reader(String firstname, String lastname, LocalDate singUpDate, List<Rentals> rentalBook) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.singUpDate = singUpDate;
        this.rentalBook = rentalBook;
    }
}
