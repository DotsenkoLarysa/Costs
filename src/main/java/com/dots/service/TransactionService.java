package com.dots.service;

import com.dots.persistence.model.Transaction;
import com.dots.persistence.repo.TransactionRepository;
import com.dots.web.exception.RecordNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getAllTransactions()
    {
        List<Transaction> result = (List<Transaction>) transactionRepository.findAll();

        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<>();
        }
    }

    public Transaction getTransactionById(Long id) throws RecordNotFoundException
    {
        Optional<Transaction> transaction = transactionRepository.findById(id);

        if(transaction.isPresent()) {
            return transaction.get();
        } else {
            throw new RecordNotFoundException("No transaction record exist for given id");
        }
    }

    public Transaction createOrUpdateTransaction(Transaction transaction)
    {
        long maybeNull = transaction.getTransaction_id();
        if(maybeNull == 0)
        {
            transaction = transactionRepository.save(transaction);
            return transaction;
        }
        else
        {
            Optional<Transaction> transaction1 = transactionRepository.findById(transaction.getTransaction_id());
            if(transaction1.isPresent())
            {
                Transaction newEntity = transaction1.get();
                newEntity.setName_transaction(transaction.getName_transaction());
                newEntity = transactionRepository.save(newEntity);
                return newEntity;
            } else {
                transaction = transactionRepository.save(transaction);
                return transaction;
            }
        }
    }

    public void deleteTransactionById(Long id) throws RecordNotFoundException
    {
        Optional<Transaction> transaction = transactionRepository.findById(id);

        if(transaction.isPresent())
        {
            transactionRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No transaction record exist for given id");
        }
    }
}
