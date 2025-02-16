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
    public void createAccount(UUID id, String firstName, String middleName, String lastName) {

        User user = new User(id, firstName, middleName, lastName);
        LOG.info("User Created Successfully: {}", user);

        Account account = new Account(user, 10);
        LOG.info("Account Created Successfully: {}", account);

        accounts.put(user.getId(), account);
    }

    // Get Account
    // Deposit Money
    // withdraw Money
    // Check Balance

}
