package com.dots.web.Controller;

import com.dots.persistence.model.Transaction;
import com.dots.service.TransactionService;
import com.dots.web.exception.RecordNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService= transactionService;
    }

    @RequestMapping("/show_all")
    public String getAllTransactions(Model model) {
        List<Transaction> list = transactionService.getAllTransactions();
        model.addAttribute("transactions", list);
        return "list-transactions";
    }

    @GetMapping(path={"/edit", "/edit/{id}"})
    public String editTransactionById(Model model, @PathVariable("id") Long transaction_id)
            throws RecordNotFoundException
    {
        if (transaction_id != null) {
            Transaction transaction = transactionService.getTransactionById(transaction_id);
            model.addAttribute("transaction", transaction);
        } else {
            model.addAttribute("transaction", new Transaction());
        }
        return "add-edit-transaction";
    }

    @PostMapping("/create")
    public String createOrUpdateTransaction(Transaction transaction){
        transactionService.createOrUpdateTransaction(transaction);
        return "redirect:/";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTransactionById(Model model, @PathVariable("id") Long id)
            throws RecordNotFoundException
    {
        transactionService.deleteTransactionById(id);
        return "redirect:/";
    }


}
