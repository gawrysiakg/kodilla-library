package com.library.kodillalibrary;

import com.library.kodillalibrary.domain.*;
import com.library.kodillalibrary.repository.ExemplarRepository;
import com.library.kodillalibrary.repository.ReaderRepository;
import com.library.kodillalibrary.repository.RentRepository;
import com.library.kodillalibrary.repository.TitleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
public class RentRepositoryTestSuite {



    @Autowired
    private RentRepository rentRepository;
    @Autowired
    private TitleRepository titleRepository;
    @Autowired
    private ReaderRepository readerRepository;
    @Autowired
    private ExemplarRepository exemplarRepository;



    @Test
    public void testRentRepositorySave() {
        //Given
        Title title = new Title( "Bajki dla dzieci", "Grzegorz Nowak", 2019);
        Exemplar exemplar = new Exemplar(title, BookStatus.AVAILABLE);
        Exemplar exemplar2 = new Exemplar(title, BookStatus.RENTED);
       // title.addExemplar(exemplar);
        title.addExemplar(exemplar2);
       // titleRepository.save(title);
        Reader reader = new Reader("Kamil", "Zawada", LocalDate.of(2016, 11, 22));
        //readerRepository.save(reader);
        Rent rent = new Rent(reader, exemplar, LocalDate.of(2022, 11, 28), LocalDate.of(2022, 12, 28));
       // rent.setExemplar(exemplar);
       // exemplar.setRent(rent);
        //When
        rentRepository.save(rent);
        Long id = rent.getId();
        Optional<Rent> result = rentRepository.findById(id);

        //Then
        Assertions.assertFalse(result.isEmpty());
        //CleanUp
        rentRepository.delete(rent);
    }





}
