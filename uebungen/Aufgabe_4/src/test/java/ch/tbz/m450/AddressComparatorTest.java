package ch.tbz.m450;

import ch.tbz.m450.repository.Address;
import ch.tbz.m450.util.AddressComparator;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddressComparatorTest {

    @Test
    void testCompare_DifferentLastNames() {
        Address a1 = new Address(1, "Alice", "Brown", "123456789", new Date());
        Address a2 = new Address(2, "Alice", "Smith", "123456789", new Date());
        AddressComparator comparator = new AddressComparator();

        int result = comparator.compare(a1, a2);
        assertEquals(-17, result); // "Brown" comes before "Smith"
    }

    @Test
    void testCompare_DifferentFirstNames() {
        Address a1 = new Address(1, "Alice", "Smith", "123456789", new Date());
        Address a2 = new Address(2, "Bob", "Smith", "123456789", new Date());
        AddressComparator comparator = new AddressComparator();

        int result = comparator.compare(a1, a2);
        assertEquals(-1, result); // "Alice" comes before "Bob"
    }

    @Test
    void testCompare_DifferentPhoneNumbers() {
        Address a1 = new Address(1, "Alice", "Smith", "123456789", new Date());
        Address a2 = new Address(2, "Alice", "Smith", "987654321", new Date());
        AddressComparator comparator = new AddressComparator();

        int result = comparator.compare(a1, a2);
        assertEquals(-8, result); // "123456789" comes before "987654321"
    }

    @Test
    void testCompare_DifferentRegistrationDates() {
        Address a1 = new Address(1, "Alice", "Smith", "123456789", new Date(1000000000000L));
        Address a2 = new Address(2, "Alice", "Smith", "123456789", new Date(2000000000000L));
        AddressComparator comparator = new AddressComparator();

        int result = comparator.compare(a1, a2);
        assertEquals(-1, result); // Earlier date comes first
    }

    @Test
    void testCompare_AllAttributesEqual() {
        Date date = new Date();
        Address a1 = new Address(1, "Alice", "Smith", "123456789", date);
        Address a2 = new Address(2, "Alice", "Smith", "123456789", date);
        AddressComparator comparator = new AddressComparator();

        int result = comparator.compare(a1, a2);
        assertEquals(0, result); // Both addresses are considered equal
    }
}
