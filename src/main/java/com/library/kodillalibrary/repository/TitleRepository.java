package com.library.kodillalibrary.repository;

import com.library.kodillalibrary.domain.Title;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Repository
public interface TitleRepository extends CrudRepository <Title, Long>{

    @Override
    Optional<Title> findById(Long id);
}
