package com.task.interviewtask.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GeoPositionDTO {
    private String latitude;
    private String longitude;
}
