package com.thecollinsbyte;

public class CreditCardPayment extends Payment implements Refundable {
    private String cardNumber;
    private String expiryDate;
    private String cvv;

    public CreditCardPayment(double amount, String payerName, String cardNumber,
                             String expiryDate, String cvv) {
        super(amount, payerName);
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    @Override
    public boolean processPayment() {
        if (amount > MAX_TRANSACTION_LIMIT) {
            System.out.println("Transaction amount exceeds limit");
            return false;
        }

        // Implement credit card payment logic here
        System.out.println("Processing Credit Card Payment...");
        System.out.println("Amount: $" + amount);
        System.out.println("Payer: " + payerName);
        System.out.println("Card Number: ****" + cardNumber.substring(cardNumber.length() - 4));
        return true;
    }

    @Override
    public boolean processRefund(String transactionId) {
        System.out.println("Processing refund for transaction: " + transactionId);
        // Implement refund logic here
        return true;
    }
}