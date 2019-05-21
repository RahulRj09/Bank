package bank;

import java.util.Date;

public class Account {
    public String holderName;
    public String number;
    private double balance;
    private Date openingDate;
    public final int RATE_OF_INTEREST = 8;

    public Account(String holderName, String number, double balance, Date openingDate) {
        this.holderName = holderName;
        this.number = number;
        this.balance = balance;
        this.openingDate = openingDate;
    }

    public void credit(double amount) {
        this.balance += amount;
    }

    public void debit(double amount) {
        if (balance >= amount) {
            this.balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return holderName + " , " + number + " , " + balance;
    }

}
