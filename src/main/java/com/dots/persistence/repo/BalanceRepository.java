package com.dots.persistence.repo;

import com.dots.persistence.model.Balance;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceRepository extends CrudRepository<Balance, Long> {

}
