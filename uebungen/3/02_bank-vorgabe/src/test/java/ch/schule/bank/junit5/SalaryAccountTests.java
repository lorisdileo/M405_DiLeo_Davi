package ch.schule.bank.junit5;

import ch.schule.SalaryAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalaryAccountTests {

	private SalaryAccount salaryAccount;

	@BeforeEach
	void setUp() {
		salaryAccount = new SalaryAccount("P-1000", -5000); // Kreditlimite: -5000 Millirappen
	}

	@Test
	void testWithdrawWithinCreditLimit() {
		salaryAccount.deposit(1, 10000); // Einzahlung: 10000 Millirappen
		assertTrue(salaryAccount.withdraw(2, 12000)); // Abheben von 12000
		assertEquals(-2000, salaryAccount.getBalance()); // Neuer Kontostand: -2000
	}

	@Test
	void testWithdrawExceedsCreditLimit() {
		salaryAccount.deposit(1, 10000); // Einzahlung: 10000 Millirappen
		assertFalse(salaryAccount.withdraw(2, 16000)); // Versuch, 16000 abzuheben
		assertEquals(10000, salaryAccount.getBalance()); // Kontostand bleibt bei 10000
	}

	@Test
	void testWithdrawNegativeAmount() {
		assertFalse(salaryAccount.withdraw(1, -1000)); // Versuch, negativen Betrag abzuheben
		assertEquals(0, salaryAccount.getBalance()); // Kontostand bleibt unverändert
	}

	@Test
	void testWithdrawZeroAmount() {
		assertTrue(salaryAccount.withdraw(1, 0)); // Versuch, 0 abzuheben
		assertEquals(0, salaryAccount.getBalance()); // Kontostand bleibt unverändert
	}

	@Test
	void testDeposit() {
		assertTrue(salaryAccount.deposit(1, 5000)); // Einzahlung von 5000
		assertEquals(5000, salaryAccount.getBalance()); // Neuer Kontostand: 5000
	}

	@Test
	void testInheritance() {
		assertTrue(salaryAccount instanceof SalaryAccount); // Sicherstellen, dass es ein SalaryAccount ist
		assertTrue(salaryAccount instanceof ch.schule.Account); // Sicherstellen, dass es von Account erbt
	}
}
