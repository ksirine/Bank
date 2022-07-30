package org.bank.service;

import org.bank.Entity.Operation;

import java.util.List;

public interface OperationService {

     List<Operation> findByAccountId(String accountId);

     Operation save(Operation operation);
}
