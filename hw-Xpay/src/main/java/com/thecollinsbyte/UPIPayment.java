package com.thecollinsbyte;

public class UPIPayment extends Payment implements Refundable {
    private String upiId;
    private static final String UPI_PATTERN = "^[\\w.-]+@[\\w.-]+$";

    public UPIPayment(double amount, String payerName, String upiId) {
        super(amount, payerName);
        this.upiId = upiId;
    }

    @Override
    public boolean processPayment() {
        if (amount > MAX_TRANSACTION_LIMIT) {
            System.out.println("Transaction amount exceeds limit");
            return false;
        }

        if (!upiId.matches(UPI_PATTERN)) {
            System.out.println("Invalid UPI ID format");
            return false;
        }

        // Implement UPI payment logic here
        System.out.println("Processing UPI Payment...");
        System.out.println("Amount: $" + amount);
        System.out.println("Payer: " + payerName);
        System.out.println("UPI ID: " + upiId);
        return true;
    }

    @Override
    public boolean processRefund(String transactionId) {
        System.out.println("Processing refund for transaction: " + transactionId);
        // Implement refund logic here
        return true;
    }
}