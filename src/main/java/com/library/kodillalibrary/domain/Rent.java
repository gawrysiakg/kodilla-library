package com.library.kodillalibrary.domain;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "BOOK_RENTS")
public class Rent {

    @Id
    @NonNull
    @Column(name = "ID", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long rentId;


    @Column(name = "RENTAL_DATE")
    @NonNull
    private LocalDate rentalDate;


    @Column(name = "RETURN_DATE")
    @NonNull
    private LocalDate returnDate;


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




//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "BOOK_ID")
//    private Book book;

}
