package com.library.kodillalibrary.controller;

import com.library.kodillalibrary.domain.Reader;
import com.library.kodillalibrary.domain.dto.ReaderDto;
import com.library.kodillalibrary.mapper.ReaderMapper;
import com.library.kodillalibrary.service.ReaderDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/readers")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ReaderController {

    private final ReaderDbService readerDbService;
    private final ReaderMapper readerMapper;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createReader(@RequestBody ReaderDto readerDto){
        Reader reader = readerMapper.mapToReader(readerDto);
        readerDbService.saveReader(reader);
        return ResponseEntity.ok().build();
    }

}
