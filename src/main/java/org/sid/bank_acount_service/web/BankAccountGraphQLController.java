package org.sid.bank_acount_service.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.bank_acount_service.dto.BankAccountRequestDTO;
import org.sid.bank_acount_service.dto.BankAccountResponseDTO;
import org.sid.bank_acount_service.entities.BankAccount;
import org.sid.bank_acount_service.entities.Customer;
import org.sid.bank_acount_service.repositories.BankAccountRepository;
import org.sid.bank_acount_service.repositories.CustomerRepository;
import org.sid.bank_acount_service.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphQLController {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountService accountService;
    @Autowired
    private CustomerRepository customerRepository;

    @QueryMapping
    public List<BankAccount> accountList(){
        return bankAccountRepository.findAll();
    }

    @QueryMapping
    public BankAccount bankAccountById(@Argument String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
    }

    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount){
        return accountService.addAccount(bankAccount);
    }

    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id,@Argument BankAccountRequestDTO bankAccount){
        return accountService.updateAccount(id,bankAccount);
    }

    @MutationMapping
    public Boolean deleteAccount(@Argument String id){
        bankAccountRepository.deleteById(id);
        return true;
    }

    @QueryMapping
    public List<Customer> customers(){
        return customerRepository.findAll();
    }
}

@Data @NoArgsConstructor @AllArgsConstructor
class BankAccountDTO {
    private String type;
    private Double balance;
    private String currency;
}
/*
record BankAccountDTO(Double balance, String type, String currency){
}*/
