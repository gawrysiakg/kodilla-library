package com.library.kodillalibrary.repository;

import com.library.kodillalibrary.domain.Exemplar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Repository
public interface ExemplarRepository extends CrudRepository<Exemplar, Long> {

    @Override
    Optional<Exemplar> findById(Long id);
}
