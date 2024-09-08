import org.group5.Account;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    public void testInitialBalance() {
        Account account = new Account();
        assertEquals(0.0, account.getBalance(), "Initial balance should be 0.0");
    }

    @Test
    public void testDeposit() {
        Account account = new Account();
        account.deposit(100.0);
        assertEquals(100.0, account.getBalance(), "Balance should be 100.0 after depositing 100.0");
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance(), "Balance should be 150.0 after depositing an additional 50.0");
    }

    @Test
    public void testDepositNegativeAmount() {
        Account account = new Account();
        account.deposit(-50.0);
        assertEquals(0.0, account.getBalance(), "Balance should remain 0.0 after attempting to deposit a negative amount");
    }

    @Test
    public void testWithdraw() {
        Account account = new Account();
        account.deposit(100.0);
        double withdrawn = account.withdraw(50.0);
        assertEquals(50.0, withdrawn, "Withdrawn amount should be 50.0");
        assertEquals(50.0, account.getBalance(), "Balance should be 50.0 after withdrawing 50.0 from 100.0");
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        Account account = new Account();
        account.deposit(50.0);
        double withdrawn = account.withdraw(100.0);
        assertEquals(0.0, withdrawn, "Withdrawn amount should be 0.0 when attempting to withdraw more than the balance");
        assertEquals(50.0, account.getBalance(), "Balance should remain 50.0 after failed withdrawal attempt");
    }

    @Test
    public void testWithdrawNegativeAmount() {
        Account account = new Account();
        account.deposit(100.0);
        double withdrawn = account.withdraw(-50.0);
        assertEquals(0.0, withdrawn, "Withdrawn amount should be 0.0 when attempting to withdraw a negative amount");
        assertEquals(100.0, account.getBalance(), "Balance should remain 100.0 after attempting to withdraw a negative amount");
    }
}