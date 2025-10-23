package org.sid.bank_acount_service.service;

import org.sid.bank_acount_service.dto.BankAccountRequestDTO;
import org.sid.bank_acount_service.dto.BankAccountResponseDTO;
import org.sid.bank_acount_service.entities.BankAccount;
import org.sid.bank_acount_service.mappers.AccountMapper;
import org.sid.bank_acount_service.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImp implements AccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .balance(bankAccountDTO.getBalance())
                .type(bankAccountDTO.getType())
                .currency(bankAccountDTO.getCurrency())
                .build();
        BankAccount saveBankAccount =  bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccountToBankAccountDTO(saveBankAccount);
        return bankAccountResponseDTO;
    }

    @Override
    public BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount = BankAccount.builder()
                .id(id)
                .createdAt(new Date())
                .balance(bankAccountDTO.getBalance())
                .type(bankAccountDTO.getType())
                .currency(bankAccountDTO.getCurrency())
                .build();
        BankAccount saveBankAccount =  bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccountToBankAccountDTO(saveBankAccount);
        return bankAccountResponseDTO;
    }
}
