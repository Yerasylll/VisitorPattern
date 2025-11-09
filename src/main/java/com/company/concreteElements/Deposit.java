package com.company.concreteElements;

import com.company.element.Transaction;
import com.company.visitor.TransactionVisitor;

public class Deposit implements Transaction {
    private double amount;
    private String accountNumber;

    public Deposit(String accountNumber, double amount) {
        this.amount = amount;
        this.accountNumber = accountNumber;
    }

    @Override
    public void accept(TransactionVisitor visitor) {
        visitor.visitDeposit(this);
    }

    @Override
    public double getAmount() {
        return amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
