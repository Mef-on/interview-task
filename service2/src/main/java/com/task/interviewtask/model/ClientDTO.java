package com.task.interviewtask.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONPropertyName;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {
    Long _id;
    String _type;
    String key;
    String name;
    String fullName;
    String iataAirportCode;
    String type;
    String country;
    String latitude;
    String longitude;
    Long locationId;
    Boolean inEurope;
    String countryCode;
    String coreCountry;
    String distance;
}

