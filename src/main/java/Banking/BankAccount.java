package Banking;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int id;
    private int balance;
    private final ReentrantLock lock = new ReentrantLock();

    public BankAccount(int id, int initialBalance) {
        this.id = id;
        this.balance = initialBalance;
    }

    public int getId() {
        return id;
    }

    public int getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }

    public void deposit(int amount) {
        lock.lock();
        try {
            balance += amount;
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(int amount) {
        lock.lock();
        try {
            balance -= amount;
        } finally {
            lock.unlock();
        }
    }

    public void transfer(BankAccount target, int amount) {
        // To avoid deadlock, always lock in the order of ascending account IDs
        BankAccount first = this.id < target.id ? this : target;
        BankAccount second = this.id < target.id ? target : this;

        first.lock.lock();
        second.lock.lock();
        try {
            this.balance -= amount;
            target.balance += amount;
        } finally {
            second.lock.unlock();
            first.lock.unlock();
        }
    }
}
