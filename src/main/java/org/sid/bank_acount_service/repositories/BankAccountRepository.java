package org.sid.bank_acount_service.repositories;

import org.sid.bank_acount_service.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
}
