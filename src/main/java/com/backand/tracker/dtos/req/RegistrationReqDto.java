package com.backand.tracker.dtos.req;

import lombok.Data;

@Data
public class RegistrationReqDto {
    private String username;

    private String email;

    private String password;
}
