package com.backand.tracker.services.impl;

import com.backand.tracker.domains.user.User;
import com.backand.tracker.repositories.UserRepository;
import com.backand.tracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(
            UserRepository userRepository
    ) {
        this.userRepository = userRepository;
    }
    @Override
    public User getUser(Long id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found!"));
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository
                .findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    @Override
    public User createNewUser(User user) {
        return userRepository
                .save(user);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository
                .existsByUsername(username);
    }
}
