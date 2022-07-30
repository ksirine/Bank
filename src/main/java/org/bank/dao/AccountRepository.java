package org.bank.dao;

import org.bank.Entity.Account;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;

public class AccountRepository {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bank");
    private EntityManager entityManager;

    public AccountRepository() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    public Account findByAccountId(String accountId) {
        Account account = entityManager.find(Account.class, accountId);
        if (account == null) {
            throw new EntityNotFoundException("Cannot find Account By this Id: " + accountId);
        }
        return account;
    }
    public Account update(Account account) {
        entityManager.getTransaction().begin();
        entityManager.merge(account);
        entityManager.getTransaction().commit();
        return account;
    }
}
