package org.bank;

import org.bank.Entity.Account;
import org.bank.dao.AccountRepository;
import org.bank.service.impl.AccountServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.inject.Inject;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceImplTest {


    @Mock
    AccountRepository accountRepository;

    @InjectMocks
    AccountServiceImpl accountServiceImpl;

    @Test
    public void findByAccountId_OK() {
        final String accountId = "ABC123";
        Account account = new Account();
        account.setAccountId(accountId);

        Mockito.when(accountRepository.findByAccountId(accountId)).thenReturn(account);

        Assert.assertEquals(accountServiceImpl.findByAccountId(accountId),account);
    }
}
