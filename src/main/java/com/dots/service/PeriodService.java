package com.dots.service;

import com.dots.persistence.model.Period;
import com.dots.persistence.repo.PeriodRepository;
import com.dots.web.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PeriodService {

    private final PeriodRepository periodRepository;

    @Autowired
    public PeriodService(PeriodRepository periodRepository) {
        this.periodRepository = periodRepository;
    }

    public List<Period> getAllPeriods() {
        List<Period> result = (List<Period>) periodRepository.findAll();

        if (result.size() > 0) {
            return result;
        } else {
            return new ArrayList<>();
        }
    }

    public Period getPeriodById(Long id) throws RecordNotFoundException {
        Optional<Period> period = periodRepository.findById(id);

        if (period.isPresent()) {
            return period.get();
        } else {
            throw new RecordNotFoundException("No period record exist for given id");
        }
    }

    public Period createOrUpdatePeriod(Period period) {
        long maybeNull = period.getPeriod_id();
        if (maybeNull == 0) {
            period = periodRepository.save(period);
            return period;
        } else {
            Optional<Period> period1 = periodRepository.findById(period.getPeriod_id());

            if (period1.isPresent()) {
                Period newEntity = period1.get();
                newEntity.setPeriod_name(period.getPeriod_name());
                newEntity = periodRepository.save(newEntity);

                return newEntity;
            } else {
                period = periodRepository.save(period);
                return period;
            }
        }
    }

    public void deletePeriodById(Long id) throws RecordNotFoundException {
        Optional<Period> period = periodRepository.findById(id);

        if (period.isPresent()) {
            periodRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No period record exist for given id");
        }
    }
}
