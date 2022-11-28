package com.library.kodillalibrary;

import com.library.kodillalibrary.domain.Reader;
import com.library.kodillalibrary.repository.ReaderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
public class ReaderRepositoryTestSuite {
    @Autowired
    private ReaderRepository readerRepository;


    @Test
    public void testReaderRepositorySave() {
        //Given
        Reader reader = new Reader("Anna", "Przykładowa", LocalDate.of(2015, 10, 19));
        //When
        readerRepository.save(reader);
        //Then
        Long id = reader.getReaderId();
        Optional<Reader> readReader = readerRepository.findById(id);
        Assertions.assertTrue(readReader.isPresent());
        //CleanUp
        readerRepository.deleteById(id);
    }
}