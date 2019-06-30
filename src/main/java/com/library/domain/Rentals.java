package com.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @Setter
    @JoinColumn
    private Book bookId;
    @ManyToOne
    @JoinColumn
    @Setter
    private Reader readerId;
    private LocalDate rentDate;
    private LocalDate giveBackDate;


}
