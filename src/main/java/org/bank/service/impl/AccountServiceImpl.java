package org.bank.service.impl;

import org.bank.Entity.Account;
import org.bank.dao.AccountRepository;
import org.bank.service.AccountService;
import org.hibernate.service.spi.InjectService;

import javax.inject.Inject;

public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    @Inject
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account findByAccountId(String accountId) {
        return accountRepository.findByAccountId(accountId);
    }

    @Override
    public Account update(Account account) {
        return accountRepository.update(account);
    }
}
