package bank;
import java.util.Date;
import java.util.List;

public class Account {
    public String holderName;
    public String number;
    private double balance;
    private Date openingDate;
    public final int RATE_OF_INTEREST_PER_ANNUM = 10;

    public Account(String holderName, String number, double balance, Date openingDate){
        this.holderName = holderName;
        this.number = number;
        this.balance = balance;
        this.openingDate = openingDate;
    }

    public void credit(double amount, Date creditDate){
        this.balance += amount;
    }

    public void debit(double amount, Date debitDate){
        if (balance >= amount){
            this.balance -= amount;
        }
    }

    public double getBalance(){
        return getBalance(0);
    }

    public double getBalance(int year){
        return balance + (RATE_OF_INTEREST_PER_ANNUM * year * balance) / 100;
    }
    public List<Transaction> getPassBook(){
        return null;
    }
    @Override
    public String toString(){
        return holderName + " , " + number + " , " + balance;
    }

}
