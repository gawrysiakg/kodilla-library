package com.library.kodillalibrary.domain;

import lombok.*;

import javax.persistence.*;
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
    @NonNull
    @Column(name = "ID", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long readerId;

    @Column(name = "FIRST_NAME")
    @NonNull
    private String firstName;

    @Column(name = "LAST_NAME")
    @NonNull
    private String lastName;

    @Column(name = "REGISTRATION_DATE")
    @NonNull
    private Date registrationDate;


    @OneToMany(
            targetEntity = Rent.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "reader")
    private List<Rent> readerRentList;



    public Reader(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.registrationDate = new Date();
    }

}
