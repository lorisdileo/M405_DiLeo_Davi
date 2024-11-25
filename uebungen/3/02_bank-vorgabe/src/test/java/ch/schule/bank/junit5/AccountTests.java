package ch.schule.bank.junit5;

import ch.schule.Account;
import ch.schule.Booking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTests {

    private Account account;

    // Testklasse für Account, da Account abstract ist
    static class TestAccount extends Account {
        public TestAccount(String id) {
            super(id);
        }
    }

    @BeforeEach
    void setUp() {
        account = new TestAccount("TestAccount123");
    }

    @Test
    void testInit() {
        assertEquals("TestAccount123", account.getId());
        assertEquals(0, account.getBalance());
    }

    @Test
    void testDepositSuccess() {
        assertTrue(account.deposit(1, 1000));
        assertEquals(1000, account.getBalance());
    }

    @Test
    void testDepositNegativeAmount() {
        assertFalse(account.deposit(1, -1000));
        assertEquals(0, account.getBalance());
    }

    @Test
    void testWithdrawSuccess() {
        account.deposit(1, 1000);
        assertTrue(account.withdraw(2, 500));
        assertEquals(500, account.getBalance());
    }

    @Test
    void testWithdrawInsufficientFunds() {
        account.deposit(1, 500);
        assertTrue(account.withdraw(2, 1000));
        assertEquals(-500, account.getBalance());
    }

    @Test
    void testWithdrawNegativeAmount() {
        account.deposit(1, 1000);
        assertFalse(account.withdraw(2, -500));
        assertEquals(1000, account.getBalance());
    }

    @Test
    void testCanTransact() {
        assertTrue(account.canTransact(1)); // Keine Buchungen vorhanden
        account.deposit(1, 1000);
        assertFalse(account.canTransact(0)); // Datum vor der letzten Buchung
        assertTrue(account.canTransact(2)); // Datum nach der letzten Buchung
    }

    @Test
    void testPrint() {
        account.deposit(1, 1000);
        account.withdraw(2, 500);

        // Aufruf der Methode ohne Parameter
        assertDoesNotThrow(() -> account.print());
    }

    @Test
    void testMonthlyPrint() {
        account.deposit(360, 1000); // Januar 1971
        account.withdraw(390, 500); // Februar 1971

        // Aufruf der Methode mit year und month als Parameter
        assertDoesNotThrow(() -> account.print(1971, 1));
        assertDoesNotThrow(() -> account.print(1971, 2));
    }

    @Test
    void testGetBooking() {
        Booking booking = new Booking(1, 1000);
        account.setBooking(booking);
        assertEquals(booking, account.getBooking());
    }
}
