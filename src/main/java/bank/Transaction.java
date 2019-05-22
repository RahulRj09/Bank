package bank;

import java.util.Date;

public class Transaction{
    public String accountNumber;
    public Date date;
    public double amount;

    public Transaction(String accountNumber, Date date, double amount) {
        this.accountNumber = accountNumber;
        this.date = date;
        this.amount = amount;
    }
}
