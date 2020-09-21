package th.ac.ku.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import th.ac.ku.atm.model.BankAccount;
import th.ac.ku.atm.service.BankAccountService;

@Controller
public class BankAccountController {

    private BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping("/bankaccount")
    public String getBankAccountPage(Model model) {
        model.addAttribute("allBankAccount", bankAccountService.getBankAccount());
        return "bankaccount";
    }

    @PostMapping("/bankaccount")
    public String registerBankAccount(@ModelAttribute BankAccount bankAccount, Model model) {
        bankAccountService.createBankAccount(bankAccount);
        model.addAttribute("allBankAccount", bankAccountService.getBankAccount());
        return "redirect:bankaccount";
    }
}
