package com.company.concreteVisitor;

import com.company.concreteElements.Commission;
import com.company.concreteElements.Deposit;
import com.company.concreteElements.Transfer;
import com.company.concreteElements.Withdrawal;
import com.company.visitor.TransactionVisitor;

public class ReportVisitor implements TransactionVisitor {
    private int totalTransactions = 0;
    private double totalAmount = 0;

    @Override
    public void visitDeposit(Deposit deposit) {
        totalTransactions++;
        totalAmount += deposit.getAmount();
        System.out.println("Report: Deposit of $" + deposit.getAmount() +
                " to account " + deposit.getAccountNumber());
    }

    @Override
    public void visitWithdrawal(Withdrawal withdrawal) {
        totalTransactions++;
        totalAmount += withdrawal.getAmount();
        System.out.println("Report: Withdrawal of $" + withdrawal.getAmount() +
                " from account " + withdrawal.getAccountNumber());
    }

    @Override
    public void visitLoan(Commission com) {
        totalTransactions++;
        totalAmount += com.getAmount();
        System.out.println("Report: Commission of $" + com.getAmount() +
                " with " + com.getInterestRate() + "% interest");
    }

    @Override
    public void visitTransfer(Transfer transfer) {
        totalTransactions++;
        totalAmount += transfer.getAmount();
        System.out.println("Report: Transfer of $" + transfer.getAmount() +
                " from " + transfer.getFromAccount() +
                " to " + transfer.getToAccount());
    }

    public void printSummary() {
        System.out.println("\n=== SUMMARY ===");
        System.out.println("Total Transactions: " + totalTransactions);
        System.out.println("Total Amount: $" + totalAmount);
    }
}
