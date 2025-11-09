package com.company.concreteElements;

import com.company.element.Transaction;
import com.company.visitor.TransactionVisitor;

public class Transfer implements Transaction {
    private double amount;
    private String fromAccount;
    private String toAccount;

    public Transfer(String fromAccount, String toAccount, double amount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }

    @Override
    public void accept(TransactionVisitor visitor) {
        visitor.visitTransfer(this);
    }

    @Override
    public double getAmount() {
        return amount;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }
}
