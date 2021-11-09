package com.task.interviewtask.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class GeoPositionDTO {
    String latitude;
    String longitude;
}
