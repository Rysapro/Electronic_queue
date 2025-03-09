package com.example.queue2.repository;

import com.example.queue2.domain.model.User;
import com.example.queue2.repository.base.BaseRepository;

import java.util.Optional;

public interface UserRepository extends BaseRepository<User> {

    Optional<User> findByEmail(String email);
}
