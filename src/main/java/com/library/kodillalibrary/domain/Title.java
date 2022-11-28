package com.library.kodillalibrary.domain;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TITLES")
public class Title {

    @Id
    @NotNull
    @Column(name = "ID", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name="TITLE")
    @NotNull
    private String title;


    @Column(name="AUTHOR")
    @NotNull
    private String author;


    @Column(name="PUBLICATION_YEAR")
    @NotNull
    private int year;

    @OneToMany(
            targetEntity = Exemplar.class,
            mappedBy = "title",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Exemplar> exemplars = new ArrayList<>();


    public Title(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public Title(Long id, String title, String author, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public void addExemplar(Exemplar exemplar) {
        exemplars.add(exemplar);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Title title1 = (Title) o;
        return year == title1.year && id.equals(title1.id) && title.equals(title1.title) && author.equals(title1.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, year);
    }


}
