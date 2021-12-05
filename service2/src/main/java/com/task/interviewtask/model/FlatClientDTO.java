package com.task.interviewtask.model;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class FlatClientDTO {
    private Long _id;
    private String _type;
    private String key;
    private String name;
    private String fullName;
    private String iata_airport_code;
    private String type;
    private String country;
    @With
    private String latitude;
    @With
    private String longitude;
    private String location_id;
    private Boolean inEurope;
    private String countryCode;
    private String coreCountry;
    private String distance;

    public FlatClientDTO mapGeoPosition(GeoPositionDTO geoPositionDTO) {
        if (geoPositionDTO != null) {
            return this
                    .withLongitude(geoPositionDTO.getLongitude())
                    .withLatitude(geoPositionDTO.getLatitude());
        }
        return this;
    }
}
