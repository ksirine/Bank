package org.bank.service.impl;

import org.bank.Entity.Operation;
import org.bank.dao.OperationRepository;
import org.bank.service.OperationService;

import javax.inject.Inject;
import java.util.List;

public class OperationServiceImpl implements OperationService {

    private OperationRepository operationRepository;

    @Inject
    public OperationServiceImpl(OperationRepository operationRepository){
        this.operationRepository = operationRepository;
    }

    @Override
    public List<Operation> findByAccountId(String accountId) {
        return operationRepository.findByAccountId(accountId);
    }

    @Override
    public Operation save(Operation operation) {
        return operationRepository.save(operation);
    }
}
