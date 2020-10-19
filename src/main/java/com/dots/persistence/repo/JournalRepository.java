package com.dots.persistence.repo;

import com.dots.persistence.model.Journal;

import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface JournalRepository extends CrudRepository<Journal, Long> {
    List<Journal> findByCategoryId(long categoryId);
    List<Journal> findByTransactionId(long transactionId);
    List<Journal> findByPeriodId(long periodId);
    List<Journal> findByDate(Date eventDate);
}
