package com.backand.tracker.modules.user;

import com.backand.tracker.modules.user.dto.res.UserDto;
import com.backand.tracker.utils.AbstractMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends AbstractMapper<User, UserDto> {

    @Autowired
    public UserMapper() {
        super(User.class, UserDto.class);
    }
}
