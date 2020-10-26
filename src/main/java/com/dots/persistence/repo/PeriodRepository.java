package com.dots.persistence.repo;

import com.dots.persistence.model.Period;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodRepository extends CrudRepository<Period, Long> {

}
