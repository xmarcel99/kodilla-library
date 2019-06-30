package com.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Reader {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "reader_id",unique = true)
    private int readerId;
    private String firstname;
    private String lastname;
    private LocalDate singUpDate;
    @OneToMany(
            targetEntity = Rentals.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "readerId"
    )
    private List<Rentals> rentalBook;

}
