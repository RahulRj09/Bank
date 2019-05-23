package bank;
import java.util.Date;

public class Client {

    public static void main(String[] args) {
        Account rahul = new Account("rahul", "1234", 0, new Date(2019, 5, 21));
        rahul.credit(100, new Date(2019, 5, 22));
        rahul.debit(100, new Date(2019, 5, 22));
        for (Transaction forTransaction : rahul.getPassBook()) {
            System.out.println(forTransaction);
        }
    }
}