package com.library.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "EXEMPLARS")
public class Exemplar {


    @Id
    @NonNull
    @Column(name = "ID", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)  //ORDINAL
    @Column(name= "STATUS")
    private BookStatus status; // =status.AVAILABLE;


    @ManyToOne(
        fetch = FetchType.EAGER,
        cascade = CascadeType.ALL)
    @JoinColumn(name= "TITLES_ID")
    private Title title;

    @OneToOne
    @JoinColumn(name = "BOOK_RENTS_ID")
    private Rent rent;

//    public Exemplar(Title title) {
//        this.title = title;
//    }

}
