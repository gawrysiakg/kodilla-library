package com.library.kodillalibrary.repository;

import com.library.kodillalibrary.domain.Rent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface RentRepository extends CrudRepository<Rent, Long>{

    @Override
    Rent save(Rent rent);

    @Override
    List<Rent> findAll();

    @Override
    Optional<Rent> findById(Long id);


}
