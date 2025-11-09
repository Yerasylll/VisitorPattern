package com.company.concreteElements;

import com.company.element.Transaction;
import com.company.visitor.TransactionVisitor;

public class Commission implements Transaction {
    private double amount;
    private String accountNumber;
    private double interestRate;

    public Commission(String accountNumber, double amount, double interestRate) {
        this.amount = amount;
        this.accountNumber = accountNumber;
        this.interestRate = interestRate;
    }

    @Override
    public void accept(TransactionVisitor visitor) {
        visitor.visitLoan(this);
    }

    @Override
    public double getAmount() {
        return amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getInterestRate() {
        return interestRate;
    }
}
