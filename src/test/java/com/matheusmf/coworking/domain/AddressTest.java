package com.matheusmf.coworking.domain;

import com.matheusmf.coworking.domain.places.Address;
import com.matheusmf.coworking.domain.places.Email;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class AddressTest {

    @Test
    void cannotCreateAddressesWithoutCountryStateCityAndStreet() {
        assertThrows(IllegalArgumentException.class,
                () -> new Address(null, "Bahia", "Salvador", "Avenida Atlântica, 100", null));

        assertThrows(IllegalArgumentException.class,
                () -> new Address("Brasil", "", "Salvador", "Avenida Atlântica, 100", null));

        assertThrows(IllegalArgumentException.class,
                () -> new Address("Brasil", "Bahia", "", "Avenida Atlântica, 100", null));

        assertThrows(IllegalArgumentException.class,
                () -> new Address("Brasil", "Bahia", "Salvador", "", null));
    }
}
