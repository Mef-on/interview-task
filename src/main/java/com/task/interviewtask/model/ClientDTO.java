package com.task.interviewtask.model;

import lombok.Builder;
import lombok.Value;
import org.json.JSONPropertyName;

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

    @JSONPropertyName(value = "_id")
    public Long getId() {
        return id;
    }

    @JSONPropertyName(value = "_type")
    public String getFirstType() {
        return firstType;
    }

    @JSONPropertyName(value = "type")
    public String getSecondType() {
        return secondType;
    }
}