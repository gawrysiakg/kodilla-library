package com.library.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "EXEMPLARS")
public class Exemplar {


    @Id
    @NotNull
    @Column(name = "ID", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)  //ORDINAL
    @Column(name= "STATUS")
    private BookStatus status;


    @ManyToOne(
        fetch = FetchType.EAGER,
        cascade = CascadeType.ALL)
    @JoinColumn(name= "TITLES_ID")
    private Title title;

//    @OneToMany
//    @JoinColumn(name = "BOOK_RENTS_ID")
//    private Rent rent;

    public Exemplar(Title title, BookStatus status) {
        this.title = title;
        this.status = status;
    }

}
