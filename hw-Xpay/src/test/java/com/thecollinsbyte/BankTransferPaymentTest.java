package com.thecollinsbyte;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class BankTransferPaymentTest {
    private static final double VALID_AMOUNT = 1000.0;
    private static final double INVALID_AMOUNT = 150000.0;
    private static final String PAYER_NAME = "Alice Johnson";

    @Test
    @DisplayName("Test Bank Transfer with Valid Amount")
    void testValidBankTransfer() {
        BankTransferPayment payment = new BankTransferPayment(
                VALID_AMOUNT,
                PAYER_NAME,
                "1234567890",
                "BANK0001234"
        );

        assertTrue(payment.processPayment());
        assertNotNull(payment.getTransactionId());
        assertEquals(VALID_AMOUNT, payment.getAmount());
        assertEquals(PAYER_NAME, payment.getPayerName());
    }

    @Test
    @DisplayName("Test Bank Transfer with Invalid Amount")
    void testInvalidBankTransfer() {
        BankTransferPayment payment = new BankTransferPayment(
                INVALID_AMOUNT,
                PAYER_NAME,
                "1234567890",
                "BANK0001234"
        );

        assertFalse(payment.processPayment());
    }
}