package com.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Rentals {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "rental_id",unique = true)
    private int rentalId;
    @OneToOne
    @JoinColumn
    private Book bookId;
    @ManyToOne
    @JoinColumn
    private Reader readerId;
    private LocalDate rentDate;
    private LocalDate giveBackDate;

    public Rentals(Book bookId, Reader readerId, LocalDate rentDate, LocalDate giveBackDate) {
        this.bookId = bookId;
        this.readerId = readerId;
        this.rentDate = rentDate;
        this.giveBackDate = giveBackDate;
    }
}
