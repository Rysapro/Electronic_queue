package com.example.queue2.service.impl;

import com.example.queue2.domain.model.User;
import com.example.queue2.repository.UserRepository;
import com.example.queue2.service.UserService;
import com.example.queue2.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserRepository>implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }
}
