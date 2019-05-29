package bank;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {
    public String holderName;
    public String number;
    private double balance;
    private LocalDate openingDate;
    public final int RATE_OF_INTEREST_PER_ANNUM = 10;
    private final List<Transaction> transaction = new ArrayList<>();

    public Account(String holderName, String number, double balance) {
        this.holderName = holderName;
        this.number = number;
        this.balance = balance;
        this.openingDate = openingDate;
    }

    public Account credit(double amount, Date creditDate) {
        Transaction credit = new Transaction(this.number, creditDate, amount);
        transaction.add(credit);
        this.balance += amount;
        return this;
    }

    public Account debit(double amount, Date debitDate) {
        if (balance >= amount) {
            Transaction debit = new Transaction(this.number, debitDate, -amount);
            transaction.add(debit);
            this.balance -= amount;
        }
        return this;
    }

    public double getBalance() {
        return getBalance(0);
    }

    public double getBalance(int year) {
        return balance + (RATE_OF_INTEREST_PER_ANNUM * year * balance) / 100;
    }

    public List<Transaction> getPassBook() {
        return transaction;
    }

    @Override
    public String toString() {
        return holderName + " , " + number + " , " + balance;
    }

}
