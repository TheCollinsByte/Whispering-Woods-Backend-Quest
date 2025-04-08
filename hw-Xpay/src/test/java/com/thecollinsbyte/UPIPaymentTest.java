package com.thecollinsbyte;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class UPIPaymentTest {
    private static final double VALID_AMOUNT = 1000.0;
    private static final double INVALID_AMOUNT = 150000.0;
    private static final String PAYER_NAME = "Jane Smith";

    @Test
    @DisplayName("Test UPI Payment with Valid UPI ID")
    void testValidUPIPayment() {
        UPIPayment payment = new UPIPayment(
                VALID_AMOUNT,
                PAYER_NAME,
                "jane.smith@upi"
        );

        assertTrue(payment.processPayment());
        assertNotNull(payment.getTransactionId());
    }

    @Test
    @DisplayName("Test UPI Payment with Invalid UPI ID")
    void testInvalidUPIFormat() {
        UPIPayment payment = new UPIPayment(
                VALID_AMOUNT,
                PAYER_NAME,
                "invalid-upi-id"
        );

        assertFalse(payment.processPayment());
    }

    @Test
    @DisplayName("Test UPI Payment with Invalid Amount")
    void testInvalidUPIAmount() {
        UPIPayment payment = new UPIPayment(
                INVALID_AMOUNT,
                PAYER_NAME,
                "jane.smith@upi"
        );

        assertFalse(payment.processPayment());
    }

    @Test
    @DisplayName("Test UPI Refund")
    void testUPIRefund() {
        UPIPayment payment = new UPIPayment(
                VALID_AMOUNT,
                PAYER_NAME,
                "jane.smith@upi"
        );

        payment.processPayment();
        assertTrue(payment.processRefund(payment.getTransactionId()));
    }
}