package com.matheusmf.coworking.domain.place;

import com.matheusmf.coworking.domain.place.model.Address;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class AddressTest {

    @Test
    void cannotCreateAddressesWithoutCountryStateCityDistrictAndStreet() {
        assertThrows(IllegalArgumentException.class,
                () -> new Address(null, "Bahia", "Salvador", "Barra", "Avenida Atlântica, 100", null));

        assertThrows(IllegalArgumentException.class,
                () -> new Address("Brasil", "", "Salvador", "Barra", "Avenida Atlântica, 100", null));

        assertThrows(IllegalArgumentException.class,
                () -> new Address("Brasil", "Bahia", "", "Barra", "Avenida Atlântica, 100", null));

        assertThrows(IllegalArgumentException.class,
                () -> new Address("Brasil", "Bahia", "Salvador", "", "Avenida Atlântica, 100", null));

        assertThrows(IllegalArgumentException.class,
                () -> new Address("Brasil", "Bahia", "Salvador", "Barra", "", null));
    }
}
