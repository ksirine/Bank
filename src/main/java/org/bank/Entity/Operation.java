package org.bank.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table
public class Operation implements Serializable {

    @Id
    private int OperationId;

    @Column
    private Date operationDate;

    @Column
    private double amount;

    @ManyToOne
    @JoinColumn(name = "accountId_FK", nullable = false)
    private Account account;

    @Column
    private String operationType;

    public Operation() {
    }

    public int getOperationId() {
        return OperationId;
    }

    public void setOperationId(int operationId) {
        OperationId = operationId;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }
}
