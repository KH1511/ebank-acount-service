package org.sid.bank_acount_service.service;

import org.sid.bank_acount_service.dto.BankAccountRequestDTO;
import org.sid.bank_acount_service.dto.BankAccountResponseDTO;
import org.sid.bank_acount_service.entities.BankAccount;

public interface AccountService {
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);

    BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO);
}
