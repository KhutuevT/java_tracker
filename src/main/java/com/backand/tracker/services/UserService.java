package com.backand.tracker.services;

import com.backand.tracker.domains.User;
import com.backand.tracker.domains.primitives.EmailAddress;
import com.backand.tracker.domains.primitives.Password;

import java.util.List;

public interface UserService {
    User getUser(Long id);

    User getUserByUsername(String username);
    User createNewUser(User user);

    boolean existsByUsername(String username);
}
