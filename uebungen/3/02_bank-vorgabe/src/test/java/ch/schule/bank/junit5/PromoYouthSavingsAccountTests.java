package ch.schule.bank.junit5;

import ch.schule.PromoYouthSavingsAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PromoYouthSavingsAccountTests {

	private PromoYouthSavingsAccount promoYouthSavingsAccount;

	@BeforeEach
	void setUp() {
		promoYouthSavingsAccount = new PromoYouthSavingsAccount("Y-1000");
	}

	@Test
	void testDepositWithBonus() {
		// Einzahlung von 1000 (Millirappen)
		assertTrue(promoYouthSavingsAccount.deposit(1, 1000));
		// 1% Bonus auf 1000 ergibt 10, Gesamteinzahlung ist 1010
		assertEquals(1010, promoYouthSavingsAccount.getBalance());
	}

	@Test
	void testDepositNegativeAmount() {
		// Negativer Betrag darf nicht eingezahlt werden
		assertFalse(promoYouthSavingsAccount.deposit(1, -1000));
		assertEquals(0, promoYouthSavingsAccount.getBalance());
	}

	@Test
	void testDepositZeroAmount() {
		assertTrue(promoYouthSavingsAccount.deposit(1, 0));
		assertEquals(0, promoYouthSavingsAccount.getBalance());
	}

	@Test
	void testInheritance() {
		assertTrue(promoYouthSavingsAccount instanceof PromoYouthSavingsAccount);
		assertTrue(promoYouthSavingsAccount instanceof ch.schule.SavingsAccount);
	}
}
