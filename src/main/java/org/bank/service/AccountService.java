package org.bank.service;

import org.bank.Entity.Account;

public interface AccountService {

     Account findByAccountId(String accountId);
     Account update(Account account);
}
