package com.dots.service;

import com.dots.persistence.model.Balance;
import com.dots.persistence.repo.BalanceRepository;
import com.dots.web.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BalanceService {

    private final BalanceRepository balanceRepository;

    @Autowired
    public BalanceService(BalanceRepository balanceRepository) {
        this.balanceRepository = balanceRepository;
    }

    public List<Balance> getAllBalances()
    {
        List<Balance> result = (List<Balance>) balanceRepository.findAll();
        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<>();
        }
    }

    public Balance getBalanceById(Long id) throws RecordNotFoundException
    {
        Optional<Balance> balance = balanceRepository.findById(id);

        if(balance.isPresent()) {
            return balance.get();
        } else {
            throw new RecordNotFoundException("No balance record exist for given id");
        }
    }

    public Balance createOrUpdateBalance(Balance balance)
    {
        long maybeNull = balance.getBalance_id();
        if(maybeNull == 0)
        {
            balance = balanceRepository.save(balance);
            return balance;
        }
        else
        {
            Optional<Balance> balance1 = balanceRepository.findById(balance.getBalance_id());

            if(balance1.isPresent())
            {
                Balance newEntity = balance1.get();
                newEntity.setNecessary_plus(balance.getNecessary_plus());
                newEntity.setNecessary_minus(balance.getNecessary_minus());
                newEntity.setNecessary_balance(balance.getNecessary_balance());
                newEntity.setEducation_plus(balance.getEducation_plus());
                newEntity.setEducation_minus(balance.getEducation_minus());
                newEntity.setEducation_balance(balance.getEducation_balance());
                newEntity.setAccumulation_plus(balance.getAccumulation_plus());
                newEntity.setAccumulation_minus(balance.getAccumulation_minus());
                newEntity.setAccumulation_balance(balance.getAccumulation_balance());
                newEntity.setStocks_plus(balance.getStocks_plus());
                newEntity.setStocks_minus(balance.getStocks_minus());
                newEntity.setStocks_balance(balance.getStocks_balance());
                newEntity.setLeisure_plus(balance.getLeisure_plus());
                newEntity.setLeisure_minus(balance.getLeisure_minus());
                newEntity.setLeisure_balance(balance.getLeisure_balance());
                newEntity.setCharity_plus(balance.getCharity_plus());
                newEntity.setCharity_minus(balance.getCharity_minus());
                newEntity.setCharity_balance(balance.getCharity_balance());
                newEntity.setCashbook_plus(balance.getCashbook_plus());
                newEntity.setCashbook_minus(balance.getCashbook_minus());
                newEntity.setCashbook_balance(balance.getCashbook_balance());
                newEntity.setCreate_date(balance.getCreate_date());

                newEntity = balanceRepository.save(newEntity);
                return newEntity;
            } else {
                balance = balanceRepository.save(balance);
                return balance;
            }
        }
    }

    public void deleteBalanceById(Long id) throws RecordNotFoundException
    {
        Optional<Balance> balance = balanceRepository.findById(id);

        if(balance.isPresent())
        {
            balanceRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No balance record exist for given id");
        }
    }
}
