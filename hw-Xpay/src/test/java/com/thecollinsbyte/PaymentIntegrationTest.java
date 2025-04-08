package com.thecollinsbyte;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class PaymentIntegrationTest {
    private static final double VALID_AMOUNT = 1000.0;

    @Test
    @DisplayName("Test Total Transactions Counter")
    void testTotalTransactionsCounter() {
        int initialCount = Payment.getTotalTransactions();

        // Process multiple payments
        CreditCardPayment ccPayment = new CreditCardPayment(
                VALID_AMOUNT,
                "John Doe",
                "4532123456789012",
                "12/25",
                "123"
        );
        ccPayment.processPayment();

        UPIPayment upiPayment = new UPIPayment(
                VALID_AMOUNT,
                "Jane Smith",
                "jane.smith@upi"
        );
        upiPayment.processPayment();

        BankTransferPayment bankPayment = new BankTransferPayment(
                VALID_AMOUNT,
                "Alice Johnson",
                "1234567890",
                "BANK0001234"
        );
        bankPayment.processPayment();

        // Assert that the counter increased by 3
        assertEquals(initialCount + 3, Payment.getTotalTransactions());
    }

    @Test
    @DisplayName("Test Different Payment Methods")
    void testDifferentPaymentMethods() {
        // Test Credit Card Payment
        Payment ccPayment = new CreditCardPayment(
                VALID_AMOUNT,
                "John Doe",
                "4532123456789012",
                "12/25",
                "123"
        );
        assertTrue(ccPayment.processPayment());

        // Test UPI Payment
        Payment upiPayment = new UPIPayment(
                VALID_AMOUNT,
                "Jane Smith",
                "jane.smith@upi"
        );
        assertTrue(upiPayment.processPayment());

        // Test Bank Transfer
        Payment bankPayment = new BankTransferPayment(
                VALID_AMOUNT,
                "Alice Johnson",
                "1234567890",
                "BANK0001234"
        );
        assertTrue(bankPayment.processPayment());
    }
}