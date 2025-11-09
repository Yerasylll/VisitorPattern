package com.company.visitor;

import com.company.concreteElements.Commission;
import com.company.concreteElements.Deposit;
import com.company.concreteElements.Transfer;
import com.company.concreteElements.Withdrawal;

public interface TransactionVisitor {
    void visitDeposit(Deposit deposit);
    void visitWithdrawal(Withdrawal withdrawal);
    void visitLoan(Commission loan);
    void visitTransfer(Transfer transfer);
}
