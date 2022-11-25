package com.library.kodillalibrary.repository;

import com.library.kodillalibrary.domain.Rent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface RentRepository extends CrudRepository<Rent, Long>{
}
