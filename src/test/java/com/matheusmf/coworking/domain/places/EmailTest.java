package com.matheusmf.coworking.domain.places;

import com.matheusmf.coworking.domain.places.Email;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmailTest {

    @Test
    void cannotCreateEmailsWithInvalidAddress() {
        assertThrows(IllegalArgumentException.class,
                () -> new Email(null));

        assertThrows(IllegalArgumentException.class,
                () -> new Email(""));

        assertThrows(IllegalArgumentException.class,
                () -> new Email("invalid email"));
    }

    @Test
    void canCreateEmailWithValidAddress() {
        String address = "fulano@alura.com.br";
        Email email = new Email(address);
        assertEquals(address, email.getAddress());
    }
}
