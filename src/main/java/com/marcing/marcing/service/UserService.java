package com.marcing.marcing.service;

import com.marcing.marcing.dto.LoginRequest;
import com.marcing.marcing.dto.RegisterRequest;
import com.marcing.marcing.model.User;
import com.marcing.marcing.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Long login(LoginRequest loginRequest) {
        final String email = loginRequest.getEmail();
        final String password = loginRequest.getPassword();
        Optional<User> user = userRepository.findByEmail(email);
        log.info(email + " " + password);
        if (user.isPresent()) {
            if (Objects.equals(password, user.get().getPassword())){
                return user.get().getUserId();
            }
        }

        return null;
    }


    public Long register(RegisterRequest registerRequest) {
        final String email = registerRequest.getEmail();
        final String password = registerRequest.getPassword();
        User user = User.builder()
                .email(email)
                .password(password)
                .build();
        User user2 = userRepository.save(user);
        return user2.getUserId();
    }
}
