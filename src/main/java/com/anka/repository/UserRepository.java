package com.anka.repository;

import com.anka.dto.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface UserRepository extends ReactiveCrudRepository<User, String> {

    Flux<User> findByName(String name);
}