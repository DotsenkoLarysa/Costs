package com.dots.web.Controller;

import com.dots.persistence.model.Journal;
import com.dots.service.JournalService;
import com.dots.web.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/journal")
public class JournalController {

    private final JournalService journalService;

    @Autowired
    public JournalController(JournalService journalService) {
        this.journalService = journalService;
    }

    @RequestMapping("/show_all")
    public String getAllJournals(Model model) {
        List<Journal> list = journalService.getAllJournals();
        model.addAttribute("journals", list);
        return "list-journals";
    }

    @GetMapping(path={"/edit", "/edit/{id}"})
    public String editJournalById(Model model, @PathVariable("id") Long event_id)
            throws RecordNotFoundException
    {
        if (event_id != null) {
            Journal journal = journalService.getJournalById(event_id);
            model.addAttribute("journal", journal);
        } else {
            model.addAttribute("journal", new Journal());
        }
        return "add-edit-journal";
    }

    @PostMapping("/create")
    public String createOrUpdateJournal(Journal journal){
        journalService.createOrUpdateJournal(journal);
        return "redirect:/";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteJournalById(Model model, @PathVariable("id") Long id)
            throws RecordNotFoundException
    {
        journalService.deleteJournalById(id);
        return "redirect:/";
    }
}
