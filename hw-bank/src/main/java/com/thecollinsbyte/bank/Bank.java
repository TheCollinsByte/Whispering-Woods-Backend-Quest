package com.thecollinsbyte.bank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Bank {

    private static final Logger LOG = LoggerFactory.getLogger(Bank.class);

    private final Map<UUID, Account> accounts;

    public Bank() {
        accounts = new HashMap<>();
        LOG.info("Bank Object Instantiated Successfully");
    }

    // Create Account
    public Account createAccount(UUID id, String firstName, String middleName, String lastName) {

        User user = new User(id, firstName, middleName, lastName);

        Account account = new Account(user, 10);

        accounts.put(user.getId(), account);

        return accounts.get(id);
    }

    // Get Account
    public Account getAccount(UUID id) {
        return accounts.get(id);
    }

    // Deposit Money
    // withdraw Money
    // Check Balance

}
