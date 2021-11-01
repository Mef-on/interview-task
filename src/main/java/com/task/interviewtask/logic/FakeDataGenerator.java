package com.task.interviewtask.logic;

import com.github.javafaker.Faker;
import com.task.interviewtask.exception.IllegalSizeOfListException;
import com.task.interviewtask.model.ClientDTO;
import com.task.interviewtask.model.GeoPositionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class FakeDataGenerator {
    Faker faker;

    public List<ClientDTO> generateListOfClientDTO(int size) throws IllegalSizeOfListException {
        List<ClientDTO> listOfClientDTO = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            listOfClientDTO.add(generateData());
        }
        return listOfClientDTO;
    }

    private ClientDTO generateData() {
        return ClientDTO.builder()
                .firstType(faker.beer().name())
                .id(faker.random().nextLong())
                .key(faker.hacker().verb())
                .name(faker.name().name())
                .fullName(faker.name().fullName())
                .secondType(faker.animal().name())
                .country(faker.country().name())
                .geoPositionDTO(GeoPositionDTO.builder()
                        .latitude(String.valueOf(faker.random().nextDouble()))
                        .latitude(String.valueOf(faker.random().nextDouble()))
                        .build())
                .locationId(faker.random().nextLong())
                .inEurope(faker.random().nextBoolean())
                .coreCountry(faker.country().countryCode3())
                .distance(String.valueOf(faker.random().nextLong()))
                .build();
    }
}
