package ch.schule.bank.junit5;

import ch.schule.Booking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookingTests {

	private Booking booking;

	@BeforeEach
	void setUp() {
		booking = new Booking(1000, 5000); // Beispielwerte: Datum 1000 (Banktage), Betrag 5000 (Millirappen)
	}

	@Test
	void testGetDate() {
		assertEquals(1000, booking.getDate());
	}

	@Test
	void testGetAmount() {
		assertEquals(5000, booking.getAmount());
	}

	@Test
	void testPrint() {
		// Da `print` auf die Konsole ausgibt, prüfen wir, dass keine Ausnahme auftritt
		assertDoesNotThrow(() -> booking.print(10000)); // Balance: 10000 Millirappen
	}

	@Test
	void testConstructor() {
		// Teste, dass der Konstruktor die Werte korrekt setzt
		Booking newBooking = new Booking(2000, -3000);
		assertEquals(2000, newBooking.getDate());
		assertEquals(-3000, newBooking.getAmount());
	}
}
