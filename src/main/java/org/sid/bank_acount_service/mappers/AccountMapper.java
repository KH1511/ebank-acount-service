package org.sid.bank_acount_service.mappers;

import org.sid.bank_acount_service.dto.BankAccountResponseDTO;
import org.sid.bank_acount_service.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public BankAccountResponseDTO fromBankAccountToBankAccountDTO(BankAccount bankAccount) {
        BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount, bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }
}
