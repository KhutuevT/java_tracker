package com.backand.tracker.dtos.req;

import lombok.Data;

@Data
public class CreateProjectReqDto {
    private String name;
    private String descriptions;
}
