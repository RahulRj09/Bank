package banktest;
import bank.Account;
import org.junit.Test;
import java.util.Date;
import static org.junit.Assert.*;

public class AccountTest {
    @Test public void shouldCredit() {
        Account komal = new Account("komal", "123", 0, new Date(2019, 5, 21));
        komal.credit(100);
        assertEquals(100.0,komal.getBalance(),1);
    }
    @Test public void shouldDebit() {
        Account rahul = new Account("rahul", "123", 100, new Date(2019, 5, 21));
        rahul.debit(100);
        assertEquals(0.0,rahul.getBalance(),1);
    }
    @Test public void itShouldNotChangeBalanceAfterCreditAndDebitWithSameAmount(){
        Account rahul = new Account("rahul", "123", 100, new Date(2019, 5, 21));
        rahul.credit(500);
        rahul.debit(500);
        assertEquals(100.0,rahul.getBalance(),1);
    }
    @Test public void shouldCreditOneAccountNotEffectAnotherAccount(){
        Account komal = new Account("komal", "123", 0, new Date(2019, 5, 21));
        Account rahul = new Account("rahul", "123", 100, new Date(2019, 5, 21));
        komal.credit(100);
        rahul.credit(200);
        assertEquals(300.0,rahul.getBalance(),1);
        assertEquals(100.0,komal.getBalance(),1);
    }
    @Test public void shouldNotChangeBalanceIfDebitMoreThenBalance(){
        Account rahul =  new Account("rahul", "123", 100, new Date(2019, 5, 21));
        rahul.debit(200);
        assertEquals(100,rahul.getBalance(),1);
    }
    @Test public void shouldGetNetAmountAfterCalculatingSimpleInterest(){
        Account rahul =  new Account("rahul", "123", 100, new Date(2019, 5, 22));
        assertEquals(100.0,rahul.getBalance(0),0);
        assertEquals(110.0,rahul.getBalance(1),0);
        assertEquals(120.0,rahul.getBalance(2),0);
        assertEquals(130.0,rahul.getBalance(3),0);
    }
}
