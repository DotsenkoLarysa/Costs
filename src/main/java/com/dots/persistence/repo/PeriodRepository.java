package com.dots.persistence.repo;

import com.dots.persistence.model.Period;
import org.springframework.data.repository.CrudRepository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;
import java.util.List;

public interface PeriodRepository extends CrudRepository<Period, Long> {


    String addPeriod(@Valid Period period, BindingResult result, Model model);

    String deletePeriod(@PathVariable long id, Model model);

    Iterable<Period> findAll();

    Period findOne(@PathVariable long id);

   // List<Period> findByName(@PathVariable String periodname);

    // List<Period> findByName(String name);
}
