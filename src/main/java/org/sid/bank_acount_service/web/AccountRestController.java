package org.sid.bank_acount_service.web;

import org.sid.bank_acount_service.dto.BankAccountRequestDTO;
import org.sid.bank_acount_service.dto.BankAccountResponseDTO;
import org.sid.bank_acount_service.entities.BankAccount;
import org.sid.bank_acount_service.mappers.AccountMapper;
import org.sid.bank_acount_service.repositories.BankAccountRepository;
import org.sid.bank_acount_service.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AccountRestController {
    private BankAccountRepository bankAccountRepository;
    private AccountService accountService;
    private AccountMapper accountMapper;

    public AccountRestController(BankAccountRepository bankAccountRepository, AccountService accountService) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountService = accountService;
    }

    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts() {
        return bankAccountRepository.findAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id) {
        return bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Bank account with id %s not found", id)));
    }

    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO requestDTO) {
        return accountService.addAccount(requestDTO);
    }

    @PutMapping("/bankAccounts/{id}")
    public BankAccount update(@PathVariable String id,@RequestBody BankAccount bankAccount) {
        BankAccount account=bankAccountRepository.findById(id).orElseThrow();
        if (bankAccount.getBalance()!=null) account.setBalance(bankAccount.getBalance());
        if (bankAccount.getCreatedAt()!=null) account.setCreatedAt(bankAccount.getCreatedAt());
        if (bankAccount.getType()!=null) account.setType(bankAccount.getType());
        if (bankAccount.getCurrency()!=null) account.setCurrency(bankAccount.getCurrency());
        return bankAccountRepository.save(account);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccount(@PathVariable String id) {
        bankAccountRepository.deleteById(id);
    }
}
