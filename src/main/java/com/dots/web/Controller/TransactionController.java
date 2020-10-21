package com.dots.web.Controller;

import com.dots.persistence.model.Transaction;
import com.dots.persistence.repo.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    public TransactionController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    private final TransactionRepository transactionRepository;

    @GetMapping
    public Iterable<Transaction> findAll() {
        return transactionRepository.findAll();
    }


    @GetMapping("/{id}")
    public Transaction findOne(@PathVariable long id) {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Transaction Id:" + id));
    }
}
