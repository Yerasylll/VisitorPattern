package com.company;

import com.company.concreteElements.Commission;
import com.company.concreteElements.Deposit;
import com.company.concreteElements.Transfer;
import com.company.concreteElements.Withdrawal;
import com.company.concreteVisitor.ReportVisitor;
import com.company.concreteVisitor.SuspiciousActivityCheckVisitor;
import com.company.element.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Deposit("ACC001", 5000));
        transactions.add(new Withdrawal("ACC002", 5000));
        transactions.add(new Commission("ACC002", 5000,  5.5));
        transactions.add(new Transfer("ACC001", "ACC002", 5000));
        transactions.add(new Deposit("ACC003", 15000));
        transactions.add(new Commission("ACC003", 15000, 18));

        System.out.println("Processing " + transactions.size() + " transactions...\n");

        // Create visitors
        ReportVisitor reportVisitor = new ReportVisitor();
        SuspiciousActivityCheckVisitor auditVisitor = new SuspiciousActivityCheckVisitor();

        // Process all transactions with ReportVisitor
        System.out.println("=== REPORTS ===");
        for (Transaction transaction : transactions) {
            transaction.accept(reportVisitor);
        }
        reportVisitor.printSummary();

        System.out.println();

        System.out.println("=== RUNNING Suspicious Action Catcher ===");
        for (Transaction transaction : transactions) {
            transaction.accept(auditVisitor);
        }
        auditVisitor.printSummary();
    }
}