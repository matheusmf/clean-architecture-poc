package com.matheusmf.coworking.domain;

import com.matheusmf.coworking.domain.places.Phone;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PhoneTest {

    @Test
    void cannotCreatePhonesWithoutNumber() {
        assertThrows(IllegalArgumentException.class,
                () -> new Phone("71", ""));
    }

    @Test
    void cannotCreatePhonesWithoutDdd() {
        assertThrows(IllegalArgumentException.class,
                () -> new Phone("", "933554415"));
    }

    @Test
    void cannotCreatePhonesWithInvalidNumber() {
        assertThrows(IllegalArgumentException.class,
                () -> new Phone("71", "4455"));
    }

    @Test
    void canCreatePhoneWithValidNumberAndDdd() {
        String ddd = "11";
        String number = "989876777";
        Phone phone = new Phone(ddd, number);
        assertEquals(ddd, phone.getDdd());
        assertEquals(number, phone.getNumber());
    }
}
