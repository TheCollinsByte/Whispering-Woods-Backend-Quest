package com.thecollinsbyte;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class PaymentTest {
    private static final double VALID_AMOUNT = 1000.0;
    private static final double INVALID_AMOUNT = 150000.0;
    private static final String PAYER_NAME = "John Doe";

    @BeforeEach
    void setUp() {
        // Any setup if needed before each test
    }

    @Test
    @DisplayName("Test Credit Card Payment with Valid Amount")
    void testValidCreditCardPayment() {
        CreditCardPayment payment = new CreditCardPayment(
                VALID_AMOUNT,
                PAYER_NAME,
                "4532123456789012",
                "12/25",
                "123"
        );

        assertTrue(payment.processPayment());
        assertNotNull(payment.getTransactionId());
        assertEquals(VALID_AMOUNT, payment.getAmount());
        assertEquals(PAYER_NAME, payment.getPayerName());
    }

    @Test
    @DisplayName("Test Credit Card Payment with Invalid Amount")
    void testInvalidCreditCardPayment() {
        CreditCardPayment payment = new CreditCardPayment(
                INVALID_AMOUNT,
                PAYER_NAME,
                "4532123456789012",
                "12/25",
                "123"
        );

        assertFalse(payment.processPayment());
    }

    @Test
    @DisplayName("Test Credit Card Refund")
    void testCreditCardRefund() {
        CreditCardPayment payment = new CreditCardPayment(
                VALID_AMOUNT,
                PAYER_NAME,
                "4532123456789012",
                "12/25",
                "123"
        );

        payment.processPayment();
        assertTrue(payment.processRefund(payment.getTransactionId()));
    }
}