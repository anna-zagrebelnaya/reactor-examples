package com.anka.controller;

import com.anka.dto.User;
import com.anka.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public Mono<String> createUser(@Valid @RequestBody User user) {
        return userService.save(user)
                .map(User::getId);
    }

    @GetMapping
    public Flux<User> getUser(@RequestParam String name) {
        return userService.findByName(name);
    }
}