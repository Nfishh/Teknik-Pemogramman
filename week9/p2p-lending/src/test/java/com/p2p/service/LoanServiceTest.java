//LoanServiceTest.java
package com.p2p.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

import com.p2p.domain.Borrower;
import com.p2p.domain.Loan;
import com.p2p.service.LoanService;

public class LoanServiceTest {

    @Test
    void shouldRejectLoanWhenAmountIsZeroOrNegative() {

        // =====================================================
        // SCENARIO:
        // Borrower valid (verified = true)
        // Amount = 0 atau negatif
        // Maka sistem harus menolak dengan exception
        // =====================================================

        // =========================
        // Arrange
        // =========================
        Borrower borrower = new Borrower(true, 700);
        LoanService loanService = new LoanService();

        // =========================
        // Act & Assert
        // =========================
        assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, BigDecimal.ZERO);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, BigDecimal.valueOf(-100));
        });
    }
    
    @Test
    void shouldApproveLoanWhenCreditScoreIsHigh() {

        // =====================================================
        // SCENARIO:
        // Borrower terverifikasi (KYC = true)
        // Amount valid (> 0)
        // Credit score ≥ 600
        // Maka loan harus APPROVED
        // =====================================================

        // =========================
        // Arrange
        // =========================
        Borrower borrower = new Borrower(true, 700);
        LoanService loanService = new LoanService();
        BigDecimal amount = BigDecimal.valueOf(1000);

        // =========================
        // Act
        // =========================
        Loan loan = loanService.createLoan(borrower, amount);

        // =========================
        // Assert
        // =========================
        assertEquals(Loan.Status.APPROVED, loan.getStatus());
    }

     @Test
    void shouldRejectLoanWhenCreditScoreIsLow() {

        // =====================================================
        // SCENARIO:
        // Borrower terverifikasi (KYC = true)
        // Amount valid (> 0)
        // Credit score < 600
        // Maka loan harus REJECTED
        // =====================================================

        // =========================
        // Arrange
        // =========================
        Borrower borrower = new Borrower(true, 500);
        LoanService loanService = new LoanService();
        BigDecimal amount = BigDecimal.valueOf(1000);

        // =========================
        // Act
        // =========================
        Loan loan = loanService.createLoan(borrower, amount);

        // =========================
        // Assert
        // =========================
        assertEquals(Loan.Status.REJECTED, loan.getStatus());
    }
}