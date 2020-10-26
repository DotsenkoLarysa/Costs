package com.dots.persistence.repo;

import com.dots.persistence.model.Journal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalRepository extends CrudRepository<Journal, Long> {

}
