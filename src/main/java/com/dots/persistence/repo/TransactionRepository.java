package com.dots.persistence.repo;

import com.dots.persistence.model.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.PathVariable;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    Iterable<Transaction> findAll();

    Transaction findOne(@PathVariable long id);
}
