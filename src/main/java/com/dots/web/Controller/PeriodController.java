package com.dots.web.Controller;

import com.dots.persistence.model.Period;
import com.dots.service.PeriodService;
import com.dots.web.exception.RecordNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/periods")
public class PeriodController {

    private final PeriodService periodService;

    @Autowired
    public PeriodController(PeriodService periodService) {
        this.periodService = periodService;
    }

    @RequestMapping("/show_all")
    public String getAllPeriods(Model model) {
        List<Period> list = periodService.getAllPeriods();
        model.addAttribute("periods", list);
        return "list-periods";
    }

    @GetMapping(path = {"/edit", "/edit/{id}"})
    public String editPeriodById(Model model, @PathVariable("id") Long period_id)
            throws RecordNotFoundException {
        if (period_id != null) {
            Period period = periodService.getPeriodById(period_id);
            model.addAttribute("period", period);
        } else {
            model.addAttribute("period", new Period());
        }
        return "add-edit-period";
    }

    @PostMapping("/create")
    public String createOrUpdatePeriod(Period period) {
        periodService.createOrUpdatePeriod(period);
        return "redirect:/";
    }

    @DeleteMapping("/delete/{id}")
    public String deletePeriodById(Model model, @PathVariable("id") Long id)
            throws RecordNotFoundException {
        periodService.deletePeriodById(id);
        return "redirect:/";
    }
}
