package com.library.repository;

import com.library.domain.Rentals;
import org.springframework.data.repository.CrudRepository;

public interface RentalsRepository extends CrudRepository<Rentals,Integer> {
}
