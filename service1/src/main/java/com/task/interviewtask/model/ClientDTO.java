package com.task.interviewtask.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientDTO {
    private Long id;
    private String firstType;
    private String key;
    private String fullName;
    private String name;
    private String iataAirportCode;
    private String secondType;
    private String country;
    private GeoPositionDTO geoPositionDTO;
    private String locationId;
    private Boolean inEurope;
    private String countryCode;
    private String coreCountry;
    private String distance;

    @JsonProperty(value = "_id")
    public Long getId() {
        return id;
    }

    @JsonProperty(value = "location_id")
    public String getLocationId() {
        return locationId;
    }

    @JsonProperty(value = "geo_position")
    public GeoPositionDTO geoPositionDTO() {
        return geoPositionDTO;
    }

    @JsonProperty(value = " iata_airport_code")
    public String getIATAAirportCode() {
        return iataAirportCode;
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
