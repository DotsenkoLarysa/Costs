package com.dots.web.Controller;

import com.dots.persistence.model.Journal;
import com.dots.persistence.repo.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/journal")
public class JournalController {

    @Autowired
    public JournalController(JournalRepository journalRepository) {
        this.journalRepository = journalRepository;
    }

    private final JournalRepository journalRepository;

    @GetMapping
    public Iterable<Journal> findAll() {
        return journalRepository.findAll();
    }

    @GetMapping("/{id}")
    public Journal findOne(@PathVariable long id) {
        return journalRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Journal Id:" + id));}


    @GetMapping("/journalup")
    public String showJournalUpForm(Journal journal) {
        return "add-of-journal";
    }

    @PostMapping("/addjournal")
    public String addJournal(@Valid Journal journal, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-of-journal";
        }
        journalRepository.save(journal);
        model.addAttribute("journals", journalRepository.findAll());
        return "redirect:/index-journal";
    }

    @GetMapping("/edit/{id}")
    public String showJournalUpdateForm(@PathVariable long id, Model model) {
        Journal journal = journalRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid journal id:" + id));
        model.addAttribute("journal", journal);
        return "update-journal";

    }

    @PostMapping("/update/{id}")
    public String updateJournal(@PathVariable long id, @Valid Journal journal,
                                BindingResult result, Model model) {
        if (result.hasErrors()) {
            journal.setEvent_id(id);
            return "update-journal";
        }
        journalRepository.save(journal);
        model.addAttribute("journals", journalRepository.findAll());
        return "redirect:/index-journal";
    }

    @GetMapping("/delete/{id}")
    public String deleteJournal(@PathVariable long id, Model model) {
        Journal journal = journalRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid journal Id:" + id));
        journalRepository.delete(journal);
        model.addAttribute("journals", journalRepository.findAll());
        return "index-journal";
    }
}
