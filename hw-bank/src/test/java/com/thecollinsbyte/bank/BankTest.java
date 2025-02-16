package com.thecollinsbyte.bank;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    @Test
    public void createAccountTest() {
        UUID id = UUID.randomUUID();
        Bank bank = new Bank();
        bank.createAccount(id, "John", "Juma", "Saidi");
    }

}