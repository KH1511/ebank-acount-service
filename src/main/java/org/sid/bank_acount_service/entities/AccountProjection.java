package org.sid.bank_acount_service.entities;

import org.sid.bank_acount_service.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = BankAccount.class, name = "P1")
public interface AccountProjection {
    public String getId();
    public AccountType getType();
    public Double getBalance();
}
