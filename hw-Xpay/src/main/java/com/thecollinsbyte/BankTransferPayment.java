package com.thecollinsbyte;

public class BankTransferPayment extends Payment {
    private String accountNumber;
    private String ifscCode;

    public BankTransferPayment(double amount, String payerName,
                               String accountNumber, String ifscCode) {
        super(amount, payerName);
        this.accountNumber = accountNumber;
        this.ifscCode = ifscCode;
    }

    @Override
    public boolean processPayment() {
        if (amount > MAX_TRANSACTION_LIMIT) {
            System.out.println("Transaction amount exceeds limit");
            return false;
        }

        // Implement bank transfer logic here
        System.out.println("Processing Bank Transfer Payment...");
        System.out.println("Amount: $" + amount);
        System.out.println("Payer: " + payerName);
        System.out.println("Account Number: ****" +
                accountNumber.substring(accountNumber.length() - 4));
        System.out.println("IFSC Code: " + ifscCode);
        return true;
    }
}