package com.task.interviewtask.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ClientDTO {
    Long id;
    String firstType;
    String key;
    String name;
    String fullName;
    String iataAirportCode;
    String secondType;
    String country;
    GeoPositionDTO geoPositionDTO;
    Long locationId;
    Boolean inEurope;
    String countryCode;
    String coreCountry;
    String distance;

    @JsonProperty(value = "_id")
    public Long getId() {
        return id;
    }

    @JsonProperty(value = "_type")
    public String getFirstType() {
        return firstType;
    }

    @JsonProperty(value = "type")
    public String getSecondType() {
        return secondType;
    }
}
