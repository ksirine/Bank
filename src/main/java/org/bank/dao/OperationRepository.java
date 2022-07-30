package org.bank.dao;

import org.bank.Entity.Account;
import org.bank.Entity.Operation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class OperationRepository {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bank");
    private EntityManager entityManager;

    public OperationRepository() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    public Operation save(Operation operation) {
        entityManager.getTransaction().begin();
        entityManager.persist(operation);
        entityManager.getTransaction().commit();
        return operation;
    }

    public List<Operation> findByAccountId(String accountId) {
        return entityManager.createNativeQuery("select * from Operation where accountId_FK =  ? ", Operation.class)
                .setParameter(1, accountId)
                .getResultList();
    }

    public void close(){
        entityManager.close();
    }
}
