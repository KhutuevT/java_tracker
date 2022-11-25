package com.backand.tracker.services.impl;

import com.backand.tracker.domains.User;
import com.backand.tracker.domains.primitives.EmailAddress;
import com.backand.tracker.domains.primitives.Password;
import com.backand.tracker.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User getUser(Long id) {
        return null;
    }

    @Override
    public User createNewUser(String name, EmailAddress emailAddress, Password password) {
        return null;
    }
}
