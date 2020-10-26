package com.dots.service;

import com.dots.persistence.model.Journal;
import com.dots.persistence.repo.JournalRepository;
import com.dots.web.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JournalService {

    private final JournalRepository journalRepository;

    @Autowired
    public JournalService(JournalRepository journalRepository) {
        this.journalRepository = journalRepository;
    }

    public List<Journal> getAllJournals() {
        List<Journal> result = (List<Journal>) journalRepository.findAll();
        if (result.size() > 0) {
            return result;
        } else {
            return new ArrayList<>();
        }
    }

    public Journal getJournalById(Long id) throws RecordNotFoundException {
        Optional<Journal> journal = journalRepository.findById(id);

        if (journal.isPresent()) {
            return journal.get();
        } else {
            throw new RecordNotFoundException("No journal record exist for given id");
        }
    }

    public Journal createOrUpdateJournal(Journal journal) {
        long maybeNull = journal.getEvent_id();
        if (maybeNull == 0) {
            journal = journalRepository.save(journal);
            return journal;
        } else {
            Optional<Journal> journal1 = journalRepository.findById(journal.getEvent_id());

            if (journal1.isPresent()) {
                Journal newEntity = journal1.get();
                newEntity.setCategoryId(journal.getCategoryId());
                newEntity.setTransactionId(journal.getTransactionId());
                newEntity.setEvent_sum(journal.getEvent_sum());
                newEntity.setEvent_date(journal.getEvent_date());
                newEntity.setDescription(journal.getDescription());
                newEntity.setPeriodId(journal.getPeriodId());
                newEntity = journalRepository.save(newEntity);

                return newEntity;
            } else {
                journal = journalRepository.save(journal);
                return journal;
            }
        }
    }

    public void deleteJournalById(Long id) throws RecordNotFoundException {
        Optional<Journal> journal = journalRepository.findById(id);

        if (journal.isPresent()) {
            journalRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No journal record exist for given id");
        }
    }
}
