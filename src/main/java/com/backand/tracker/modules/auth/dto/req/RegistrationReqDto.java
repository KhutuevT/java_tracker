package com.backand.tracker.modules.auth.dto.req;

import lombok.Data;

@Data
public class RegistrationReqDto {
    private String username;

    private String email;

    private String password;
}
