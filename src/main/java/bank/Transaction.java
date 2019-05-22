package bank;

import java.util.Date;
import java.util.Objects;

public class Transaction{
    public String accountNumber;
    public Date date;
    public double amount;

    public Transaction(String accountNumber, Date date, double amount) {
        this.accountNumber = accountNumber;
        this.date = date;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Double.compare(that.amount, amount) == 0 &&
                Objects.equals(accountNumber, that.accountNumber) &&
                Objects.equals(date, that.date);
    }
}
