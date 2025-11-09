package com.company.concreteElements;

import com.company.element.Transaction;
import com.company.visitor.TransactionVisitor;

public class Withdrawal implements Transaction {
    private double amount;
    private String accountNumber;

    public Withdrawal(String accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    @Override
    public void accept(TransactionVisitor visitor) {
        visitor.visitWithdrawal(this);
    }

    @Override
    public double getAmount() {
        return amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
