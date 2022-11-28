package com.library.kodillalibrary;

import com.library.kodillalibrary.domain.BookStatus;
import com.library.kodillalibrary.domain.Exemplar;
import com.library.kodillalibrary.domain.Title;
import com.library.kodillalibrary.repository.ExemplarRepository;
import com.library.kodillalibrary.repository.TitleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class TitleRepositoryTestSuite {

    @Autowired
    private ExemplarRepository exemplarRepository;
    @Autowired
    private TitleRepository titleRepository;


    @Test
    void testTitleRepositorySaveExemplar(){
        //Given
        Title title = new Title( "Wierszyki dla dzieci", "Mariusz Nowak", 2010);
        Exemplar exemplar1 = new Exemplar(title, BookStatus.AVAILABLE);
        Exemplar exemplar2 = new Exemplar(title, BookStatus.RENTED);
        Exemplar exemplar3 = new Exemplar(title, BookStatus.AVAILABLE);
        title.addExemplar(exemplar1);
        title.addExemplar(exemplar2);
        title.addExemplar(exemplar3);
        exemplar1.setTitle(title);
        exemplar2.setTitle(title);
        exemplar3.setTitle(title);
        //When
        titleRepository.save(title);
        Long id = title.getId();
        //Then
        Assertions.assertNotEquals(0, id);
        Assertions.assertNotNull(id);
        //CleanUp
        titleRepository.deleteById(id);

    }
}
