package com.library.kodillalibrary.domain;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "BOOK_RENTS")
public class Rent {

    @Id
    @NotNull
    @Column(name = "ID", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name = "RENTAL_DATE")
   // @NotNull
    private LocalDate rentalDate;


    @Column(name = "RETURN_DATE")
    //@NotNull
    private LocalDate returnDate=null;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "READER_ID")
    private Reader reader;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "EXEMPLAR_ID")
    private Exemplar exemplar;


    public Rent(Reader reader, Exemplar exemplar, LocalDate rentalDate, LocalDate returnDate) {
        this.reader = reader;
        this.exemplar = exemplar;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
    }




}
