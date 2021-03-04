package com.matheusmf.coworking.application;

import com.matheusmf.coworking.application.place.RegisterPlaceDto;
import com.matheusmf.coworking.application.place.RegisterPlaceUseCase;
import com.matheusmf.coworking.domain.place.model.Place;
import com.matheusmf.coworking.infrastructure.place.repository.MemoryPlaceRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class RegisterPlaceUseCaseTest {

    @Test
    void placeMustBePersisted() {
        // MOCK -> Mockito
        MemoryPlaceRepository repository = new MemoryPlaceRepository();
        RegisterPlaceUseCase useCase = new RegisterPlaceUseCase(repository);

        RegisterPlaceDto data = new RegisterPlaceDto(
                "Cowork Coffe",
                "Brasil",
                "São Paulo", "São Paulo", "Avenida São João", "Centro", null,
                "coworkcoffe@coffe.com");
        useCase.execute(data);

        Place coworkCoffe = repository.findByName("Cowork Coffe");

        assertEquals("Cowork Coffe", coworkCoffe.getName());
        assertEquals("Brasil", coworkCoffe.getAddress().getCountry());
        assertEquals("coworkcoffe@coffe.com", coworkCoffe.getEmail());
        assertNull(coworkCoffe.getAddress().getComplement());
    }
}
