package com.backand.tracker.services;

import com.backand.tracker.domains.User;
import com.backand.tracker.domains.primitives.EmailAddress;
import com.backand.tracker.domains.primitives.Password;

import java.util.List;

public interface UserService {
    User getUser(Long id);

    User createNewUser(String name, EmailAddress emailAddress, Password password);
}
