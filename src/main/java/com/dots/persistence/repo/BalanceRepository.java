package com.dots.persistence.repo;

import com.dots.persistence.model.Balance;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BalanceRepository extends CrudRepository<Balance, Long> {
    List<Balance> findByPeriodId(long periodId);
}
