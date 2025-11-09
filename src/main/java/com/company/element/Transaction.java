package com.company.element;

import com.company.visitor.TransactionVisitor;

public interface Transaction {
    void accept(TransactionVisitor visitor);
    double getAmount();
}
