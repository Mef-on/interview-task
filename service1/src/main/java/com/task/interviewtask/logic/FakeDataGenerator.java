package com.task.interviewtask.logic;

import com.github.javafaker.Faker;
import com.task.interviewtask.model.ClientDTO;
import com.task.interviewtask.model.GeoPositionDTO;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class FakeDataGenerator {
    private final Faker faker;

    public List<ClientDTO> generateListOfClientDTO(int size) {
        List<ClientDTO> listOfClientDTO = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            listOfClientDTO.add(generateData());
        }
        return listOfClientDTO;
    }

    private ClientDTO generateData() {
        String name = faker.name().firstName();
        return ClientDTO.builder()
                .firstType(faker.beer().name())
                .id(faker.random().nextLong())
                .key(faker.hacker().verb())
                .name(name)
                .fullName(name + " " + faker.name().lastName())
                .secondType(faker.animal().name())
                .country(faker.country().name())
                .geoPositionDTO(GeoPositionDTO.builder()
                        .latitude(String.valueOf(faker.random().nextDouble()))
                        .longitude(String.valueOf(faker.random().nextDouble()))
                        .build())
                .locationId(faker.random().nextLong())
                .inEurope(faker.random().nextBoolean())
                .coreCountry(faker.country().countryCode3())
                .distance(String.valueOf(faker.random().nextLong()))
                .build();
    }
}
