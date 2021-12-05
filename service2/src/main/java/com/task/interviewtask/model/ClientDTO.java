package com.task.interviewtask.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ClientDTO {
    private Long _id;
    private String _type;
    private String key;
    private String name;
    private String fullName;
    private String iataAirportCode;
    private String type;
    private String country;
    private String locationId;
    private Boolean inEurope;
    private String countryCode;
    private String coreCountry;
    private String distance;
    private GeoPositionDTO geo_position;
}

