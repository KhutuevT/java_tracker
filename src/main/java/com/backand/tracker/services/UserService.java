package com.backand.tracker.services;

import com.backand.tracker.domains.user.User;

public interface UserService {
    User getUser(Long id);

    User getUserByUsername(String username);
    User createNewUser(User user);

    boolean existsByUsername(String username);
}
