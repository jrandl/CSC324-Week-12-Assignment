package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void testInitialBalance() {
        BankAccount account = new BankAccount("Alice", 1000);
        assertEquals(1000, account.getBalance());
    }

    @Test
    void testDeposit() {
        BankAccount account = new BankAccount("Bob", 500);
        account.deposit(200);
        assertEquals(700, account.getBalance());
    }

    @Test
    void testWithdraw() {
        BankAccount account = new BankAccount("Charlie", 800);
        account.withdraw(300);
        assertEquals(500, account.getBalance());
    }

    @Test
    void testOverdraft() {
        BankAccount account = new BankAccount("Dana", 400);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(500);
        });
        assertEquals("Insufficient funds.", exception.getMessage());
    }
}
