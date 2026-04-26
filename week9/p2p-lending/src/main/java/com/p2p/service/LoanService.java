package com.p2p.service;

import com.p2p.domain.*;

import java.math.BigDecimal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoanService {

    private static final Logger logger = LogManager.getLogger(LoanService.class);

    public Loan createLoan(Borrower borrower, BigDecimal amount) {

          logger.info("Start creating loan");

        // =========================
        // VALIDASI (delegasi ke domain)
        // =========================
        validateBorrower(borrower);

        // =========================
        // VALIDASI AMOUNT (TC-02)
        // =========================
        validateAmount(amount);

        logger.info("Amount validated successfully");
        // =========================
        // CREATE LOAN (domain object)
        // =========================
        Loan loan = new Loan();

        // =========================
        // BUSINESS ACTION (domain behavior)
        // =========================
       if (borrower.getCreditScore() >= 600) {
        loan.approve();
        logger.info("Loan APPROVED for credit score: {}", borrower.getCreditScore());
        } else {
        loan.reject();
        logger.warn("Loan REJECTED for credit score: {}", borrower.getCreditScore());
        }

        logger.info("Loan process completed");

        return loan;

    }
    // =========================
    // PRIVATE VALIDATION METHOD (BORROWER)
    // =========================
    private void validateBorrower(Borrower borrower) {
        if (!borrower.canApplyLoan()) {
            logger.error("Borrower not verified");
            throw new IllegalArgumentException("Borrower not verified");
        }
    }

    // =========================
    // PRIVATE VALIDATION METHOD (AMOUNT)
    // =========================
    private void validateAmount(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            logger.error("Invalid loan amount: {}", amount);
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
    }
}

