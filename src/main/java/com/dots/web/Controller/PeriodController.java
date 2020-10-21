package com.dots.web.Controller;

import com.dots.persistence.model.Period;
import com.dots.persistence.repo.PeriodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/periods")
public class PeriodController {

    @Autowired
    public PeriodController(PeriodRepository periodRepository) {
        this.periodRepository = periodRepository;
    }

    private final PeriodRepository periodRepository;

    @GetMapping
    public Iterable<Period> findAll() {
        return periodRepository.findAll();
    }


    @GetMapping("/period/{periodname}")
    public List <Period> findByPeriodName(@PathVariable String periodname) {
      //  return periodRepository.findByName(periodname);
        return null;
    }

    @GetMapping("/{id}")
    public Period findOne(@PathVariable long id) {
        return periodRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Period Id:" + id));}


    @PostMapping("/addperiod")
    public String addPeriod(@Valid Period period, BindingResult result, Model model) {
        periodRepository.save(period);
        model.addAttribute("periods", periodRepository.findAll());
        return "redirect:/home";
    }


    @GetMapping("/delete/{id}")
    public String deletePeriod(@PathVariable long id, Model model) {
        Period period = periodRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid period Id:" + id));
        periodRepository.delete(period);
        model.addAttribute("periods", periodRepository.findAll());
        return "home";
    }
}
