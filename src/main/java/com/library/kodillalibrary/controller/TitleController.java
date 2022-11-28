package com.library.kodillalibrary.controller;

import com.library.kodillalibrary.controller.exceptions.TitleNotFoundException;
import com.library.kodillalibrary.domain.BookStatus;
import com.library.kodillalibrary.domain.Exemplar;
import com.library.kodillalibrary.domain.Title;
import com.library.kodillalibrary.domain.dto.ExemplarDto;
import com.library.kodillalibrary.domain.dto.TitleDto;
import com.library.kodillalibrary.mapper.ExemplarMapper;
import com.library.kodillalibrary.mapper.TitleMapper;
import com.library.kodillalibrary.service.TitleDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/v1/titles")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TitleController {

    private final TitleDbService titleDbService;
    private final TitleMapper titleMapper;
    private final ExemplarMapper exemplarMapper;



    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addTitle(@RequestBody TitleDto titleDto){
        Title title = titleMapper.mapToTitle(titleDto);
        titleDbService.saveTitle(title);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/{id}/available")
    public ResponseEntity <List<ExemplarDto>> getAvailableExemplars(@PathVariable("id") Long id) throws TitleNotFoundException {
      Title title =  titleDbService.getTitle(id);
      List<Exemplar> exemplarsList = title.getExemplars();
      List<Exemplar> availableList = exemplarsList.stream()
              .filter(e->e.getStatus().equals(BookStatus.AVAILABLE))
              .collect(Collectors.toList());
        return ResponseEntity.ok(exemplarMapper.mapToDtoList(availableList));
    }



}
