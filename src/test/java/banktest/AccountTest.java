package banktest;
import bank.Account;
import bank.Transaction;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class AccountTest {

    public static final Date TODAY  = new Date(2019, 5, 21);
    @Test public void shouldCredit() {
        Account komal = new Account("komal", "123", 0, TODAY);
        komal.credit(100, new Date(2019, 5, 22));
        assertEquals(100.0,komal.getBalance(),1);
    }

    @Test public void shouldDebit() {
        Account rahul = new Account("rahul", "123", 100, TODAY);
        rahul.debit(100, new Date(2019, 5, 22));
        assertEquals(0.0,rahul.getBalance(),1);
    }

    @Test public void itShouldNotChangeBalanceAfterCreditAndDebitWithSameAmount(){
        Account rahul = new Account("rahul", "123", 100, TODAY);
        rahul.credit(500, new Date(2019, 5, 22));
        rahul.debit(500, new Date(2019, 5, 22));
        assertEquals(100.0,rahul.getBalance(),1);
    }

    @Test public void shouldCreditOneAccountNotEffectAnotherAccount(){
        Account komal = new Account("komal", "123", 0, TODAY);
        Account rahul = new Account("rahul", "123", 100, TODAY);
        komal.credit(100, new Date(2019, 5, 22));
        rahul.credit(200, new Date(2019, 5, 22));
        assertEquals(300.0,rahul.getBalance(),1);
        assertEquals(100.0,komal.getBalance(),1);
    }

    @Test public void shouldNotChangeBalanceIfDebitMoreThenBalance(){
        Account rahul =  new Account("rahul", "123", 100, TODAY);
        rahul.debit(200, new Date(2019, 5, 22));
        assertEquals(100,rahul.getBalance(),1);
    }

    @Test public void shouldGetNetAmountAfterCalculatingSimpleInterest(){
        Account rahul =  new Account("rahul", "123", 100, TODAY);
        assertEquals(100.0,rahul.getBalance(0),0);
        assertEquals(110.0,rahul.getBalance(1),0);
        assertEquals(120.0,rahul.getBalance(2),0);
        assertEquals(130.0,rahul.getBalance(3),0);
    }

    @Test public void ifNoTransactionDoneItShouldGiveEmptyList(){
        Account rahul =  new Account("rahul", "123", 100, TODAY);
        List<Transaction> expected= new ArrayList<>();
        assertEquals(expected, rahul.getPassBook());
    }

    @Test public void ifOneTransactionDoneItShouldGiveOneTransactionList(){
        List<Transaction> expectedTransactions= new ArrayList<>();
        Account rahul =  new Account("rahul", "1234", 0, TODAY);
        Transaction credit = new Transaction("1234",TODAY,500);
        rahul.credit(500,TODAY);
        expectedTransactions.add(credit);
        assertEquals(expectedTransactions, rahul.getPassBook());
    }
    @Test public void ifOneTransactionDoneItShouldGiveTheDebitAmount(){
        List<Transaction> expectedTransactions= new ArrayList<>();
        Account rahul =  new Account("rahul", "1234", 500, TODAY);
        Transaction credit = new Transaction("1234",TODAY,500);
        rahul.debit(500,TODAY);
        expectedTransactions.add(credit);
        assertEquals(expectedTransactions, rahul.getPassBook());
    }
    @Test public void ifTheDebitAmountMoreThenCreditAmountItShouldGiveNoTransactionInTheList() {
        List<Transaction> expectedNoTransactions = new ArrayList<>();
        Account rahul = new Account("rahul", "1234", 0, TODAY);
        rahul.debit(500, TODAY);
        assertEquals(expectedNoTransactions, rahul.getPassBook());
    }
}
