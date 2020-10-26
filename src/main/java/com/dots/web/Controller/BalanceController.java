package com.dots.web.Controller;

import com.dots.persistence.model.Balance;
import com.dots.service.BalanceService;
import com.dots.web.exception.RecordNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/balances")
public class BalanceController {

    private final BalanceService balanceService;

    @Autowired
    public BalanceController(BalanceService balanceService) {
        this.balanceService = balanceService;
    }

    @RequestMapping("/show_all")
    public String getAllBalances(Model model) {
        List<Balance> list = balanceService.getAllBalances();
        model.addAttribute("balances", list);
        return "list-balances";
    }

    @GetMapping(path={"/edit", "/edit/{id}"})
    public String editBalanceById(Model model, @PathVariable("id") Long balance_id)
            throws RecordNotFoundException
    {
        if (balance_id != null) {
            Balance balance = balanceService.getBalanceById(balance_id);
            model.addAttribute("balance", balance);
        } else {
            model.addAttribute("balance", new Balance());
        }
        return "add-edit-balance";
    }

    @PostMapping("/create")
    public String createOrUpdateBalance(Balance balance){
        balanceService.createOrUpdateBalance(balance);
        return "redirect:/";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBalanceById(Model model, @PathVariable("id") Long id)
            throws RecordNotFoundException
    {
        balanceService.deleteBalanceById(id);
        return "redirect:/";
    }
}
