package th.ac.ku.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import th.ac.ku.atm.model.BankAccount;
import th.ac.ku.atm.service.BankAccountService;
import th.ac.ku.atm.model.Transaction;

@Controller
@RequestMapping("/bankaccount")
public class BankAccountController {

    private BankAccountService accountService;

    public BankAccountController(BankAccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public String getBankAccountPage(Model model) {
        model.addAttribute("bankaccounts", accountService.getBankAccounts());
        return "bankaccount";
    }

    @PostMapping
    public String openAccount(@ModelAttribute BankAccount bankAccount, Model model) {
        accountService.openAccount(bankAccount);
        model.addAttribute("bankaccounts",accountService.getBankAccounts());
        return "redirect:bankaccount";
    }

    @GetMapping("/transaction/{id}")
    public String getEditBankAccountPage(@PathVariable int id,
                                         Model model) {
        BankAccount account = accountService.getBankAccount(id);
        model.addAttribute("bankAccount", account);
        return "bankaccount-transaction";
    }

    @PostMapping("/transaction/{id}")
    public String makeTransaction(@PathVariable int id,
                                  @RequestBody MultiValueMap<String, String> formData,
                                  Model model) {

        for (String key: formData.keySet()) {
            System.out.println(key + " " + formData.get(key));
        }

        Transaction transaction = new Transaction(
                id,
                Double.parseDouble(formData.get("transactionAmount").get(0)),
                formData.get("transactionType").get(0)
        );

        accountService.makeTransaction(transaction);
        model.addAttribute("bankaccounts",accountService.getBankAccounts());
        return "redirect:/bankaccount";
    }

    @PostMapping("/delete/{id}")
    public String deleteAccount(@PathVariable int id) {
        accountService.deleteBankAccount(id);
        return "redirect:/bankaccount";

    }


}
