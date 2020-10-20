package com.dots.persistence.repo;

import com.dots.persistence.model.Journal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

public interface JournalRepository extends CrudRepository<Journal, Long> {

    String addJournal(@Valid Journal journal, BindingResult result, Model model);


    String updateJournal(@PathVariable long id, @Valid Journal journal,
                         BindingResult result, Model model);

    String deleteJournal(@PathVariable long id, Model model);

    Iterable<Journal> findAll();

    Journal findOne(@PathVariable long id);

//    List<Journal> findByCategoryId(long categoryId);
//    List<Journal> findByTransactionId(long transactionId);
//    List<Journal> findByPeriodId(long periodId);
//    List<Journal> findByDate(Date eventDate);
}
