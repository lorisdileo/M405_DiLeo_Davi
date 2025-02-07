package ch.tbz.m450.util;

import ch.tbz.m450.repository.Address;

import java.util.Comparator;

public class AddressComparator implements Comparator<Address> {

    @Override
    public int compare(Address a1, Address a2) {
        int result = a1.getLastname().compareToIgnoreCase(a2.getLastname());
        if (result != 0) {
            return result;
        }

        result = a1.getFirstname().compareToIgnoreCase(a2.getFirstname());
        if (result != 0) {
            return result;
        }

        result = a1.getPhonenumber().compareToIgnoreCase(a2.getPhonenumber());
        if (result != 0) {
            return result;
        }

        return a1.getRegistrationDate().compareTo(a2.getRegistrationDate());
    }
}
