package com.backand.tracker.services;

import com.backand.tracker.domains.User;

public interface AuthService {
    String authorization(String username, String password);

    void registration(User user);
}
