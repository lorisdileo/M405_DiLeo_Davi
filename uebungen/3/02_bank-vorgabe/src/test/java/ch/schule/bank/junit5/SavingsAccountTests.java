package ch.schule.bank.junit5;

import ch.schule.SavingsAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTests {

	private SavingsAccount savingsAccount;

	@BeforeEach
	void setUp() {
		savingsAccount = new SavingsAccount("S-1000");
	}

	@Test
	void testWithdrawSufficientBalance() {
		savingsAccount.deposit(1, 5000); // Einzahlung von 5000 Millirappen
		assertTrue(savingsAccount.withdraw(2, 3000)); // Abheben von 3000
		assertEquals(2000, savingsAccount.getBalance()); // Neuer Kontostand: 2000
	}

	@Test
	void testWithdrawInsufficientBalance() {
		savingsAccount.deposit(1, 2000); // Einzahlung von 2000 Millirappen
		assertFalse(savingsAccount.withdraw(2, 3000)); // Versuch, 3000 abzuheben
		assertEquals(2000, savingsAccount.getBalance()); // Kontostand bleibt bei 2000
	}

	@Test
	void testWithdrawNegativeAmount() {
		savingsAccount.deposit(1, 5000); // Einzahlung von 5000 Millirappen
		assertFalse(savingsAccount.withdraw(2, -1000)); // Versuch, negativen Betrag abzuheben
		assertEquals(5000, savingsAccount.getBalance()); // Kontostand bleibt unverändert
	}

	@Test
	void testWithdrawZeroAmount() {
		savingsAccount.deposit(1, 5000); // Einzahlung von 5000 Millirappen
		assertTrue(savingsAccount.withdraw(2, 0)); // Versuch, 0 abzuheben
		assertEquals(5000, savingsAccount.getBalance()); // Kontostand bleibt unverändert
	}

	@Test
	void testDeposit() {
		assertTrue(savingsAccount.deposit(1, 3000)); // Einzahlung von 3000 Millirappen
		assertEquals(3000, savingsAccount.getBalance()); // Neuer Kontostand: 3000
	}

	@Test
	void testInheritance() {
		assertTrue(savingsAccount instanceof SavingsAccount); // Sicherstellen, dass es ein SavingsAccount ist
		assertTrue(savingsAccount instanceof ch.schule.Account); // Sicherstellen, dass es von Account erbt
	}
}
