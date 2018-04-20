package com.anka.service;

import com.anka.dto.User;
import com.anka.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Mono<User> save(User user) {
        return userRepository.save(user);
    }

    public Flux<User> findByName(String name) {
        return userRepository.findByName(name);
    }
}