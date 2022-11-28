package com.library.kodillalibrary.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "READERS")
public class Reader {


    @Id
    @NotNull
    @Column(name = "ID", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long readerId;

    @Column(name = "FIRST_NAME")
    @NotNull
    private String firstName;

    @Column(name = "LAST_NAME")
    @NotNull
    private String lastName;

    @Column(name = "REGISTRATION_DATE")
    @NotNull
    private LocalDate registrationDate;


    @OneToMany(
            targetEntity = Rent.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "reader")
    private List<Rent> readerRentList=new ArrayList<>();

    public void addRentForReader(Rent rent){
        readerRentList.add(rent);
    }

    public Reader(String firstName, String lastName, LocalDate registrationDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.registrationDate = registrationDate;
    }

    public Reader(Long readerId, String firstName, String lastName, LocalDate registrationDate) {
        this.readerId = readerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.registrationDate = registrationDate;
    }
}
