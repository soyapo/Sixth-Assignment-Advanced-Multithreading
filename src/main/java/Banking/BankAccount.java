package Banking;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance;
    private final Lock lock = new ReentrantLock();

    public BankAccount() {
        this.balance = 10000;
    }


    public int getBalance() {
        // TODO
        return balance;
    }

    public Lock getLock() {
        return lock;
    }

    public void deposit(int amount) {
        // TODO
        balance += amount;
    }

    public void withdraw(int amount) {
        // TODO
        if (balance >= amount) {
            balance -= amount;
        }
    }

    public void transfer(BankAccount target, int amount) {
        // TODO
        if (this.balance >= amount) {
            this.withdraw(amount);
            target.deposit(amount);
        }
    }
}
