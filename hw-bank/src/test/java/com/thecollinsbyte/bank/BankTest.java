package com.thecollinsbyte.bank;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    private static final Logger LOG = LoggerFactory.getLogger(BankTest.class);

    private UUID id;
    private Bank bank;
    private Account account;

    @BeforeEach
    public void setUp() {
        id = UUID.randomUUID();
        bank = new Bank();
        account = bank.createAccount(id, "John", "Juma", "Saidi");
    }

    @Test
    public void createAccountTest() {
        LOG.info("Account Created Successfully: {}", account);

        assertEquals("John", account.getUser().getFirstName());
        assertEquals("Juma", account.getUser().getMiddleName());
        assertEquals("Saidi", account.getUser().getLastName());
    }

    @Test
    void getAccountTest() {
        LOG.info("Retrieving the account: {}", account);
        assertEquals("John", bank.getAccount(id).getUser().getFirstName());
        assertEquals("Juma", bank.getAccount(id).getUser().getMiddleName());
        assertEquals("Saidi", bank.getAccount(id).getUser().getLastName());
        LOG.info("Retrieving the account Successfully: {}", account);
    }
}