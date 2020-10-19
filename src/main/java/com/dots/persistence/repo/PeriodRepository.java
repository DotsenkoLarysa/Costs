package com.dots.persistence.repo;

import com.dots.persistence.model.Period;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PeriodRepository extends CrudRepository<Period, Long> {
    List<Period> findByName(String name);
}
