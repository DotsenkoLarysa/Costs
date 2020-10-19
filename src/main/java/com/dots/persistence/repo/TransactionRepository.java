package com.dots.persistence.repo;

import com.dots.persistence.model.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    List<Transaction> findByIdTransaction(Long id);
}
