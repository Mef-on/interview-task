package com.task.interviewtask.model;

import lombok.Data;
import lombok.experimental.FieldNameConstants;

@Data
@FieldNameConstants
public class GeoPositionDTO {

    String latitude;
    String longitude;
}

