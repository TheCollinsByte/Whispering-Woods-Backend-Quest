package com.thecollinsbyte;

public abstract class Payment {
    private static int totalTransactions = 0;
    protected static final double MAX_TRANSACTION_LIMIT = 100000.0;

    protected double amount;
    protected String payerName;
    protected String transactionId;

    public Payment(double amount, String payerName) {
        this.amount = amount;
        this.payerName = payerName;
        this.transactionId = generateTransactionId();
        totalTransactions++;
    }

    private String generateTransactionId() {
        return "TXN" + System.currentTimeMillis() + "_" + totalTransactions;
    }

    public abstract boolean processPayment();

    public static int getTotalTransactions() {
        return totalTransactions;
    }

    public double getAmount() {
        return amount;
    }

    public String getPayerName() {
        return payerName;
    }

    public String getTransactionId() {
        return transactionId;
    }
}