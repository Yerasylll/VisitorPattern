package com.company.concreteVisitor;

import com.company.concreteElements.Commission;
import com.company.concreteElements.Deposit;
import com.company.concreteElements.Transfer;
import com.company.concreteElements.Withdrawal;
import com.company.visitor.TransactionVisitor;

public class SuspiciousActivityCheckVisitor implements TransactionVisitor {
    private int suspiciousCount = 0;

    @Override
    public void visitDeposit(Deposit deposit) {
        if (deposit.getAmount() > 10_000) {
            System.out.println("Large deposit of $" + deposit.getAmount());
            suspiciousCount++;
        }
    }

    @Override
    public void visitWithdrawal(Withdrawal withdrawal) {
        if (withdrawal.getAmount() > 10_000) {
            System.out.println("Large withdrawal of $" + withdrawal.getAmount());
            suspiciousCount++;
        }
    }

    @Override
    public void visitLoan(Commission com) {
        if (com.getInterestRate() > 15) {
            System.out.println("High interest rate of " + com.getInterestRate() + "%");
            suspiciousCount++;
        }
    }

    @Override
    public void visitTransfer(Transfer transfer) {
        if (transfer.getAmount() > 20_000) {
            System.out.println("Large transfer of $" + transfer.getAmount());
            suspiciousCount++;
        }
    }

    public void printSummary() {
        System.out.println("\n=== AUDIT SUMMARY ===");
        if (suspiciousCount == 0) {
            System.out.println("No suspicious activities detected");
        } else {
            System.out.println("Found " + suspiciousCount + " suspicious activities");
        }
    }
}
