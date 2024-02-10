package com.marcing.marcing.controller;

import com.marcing.marcing.dto.LoginRequest;
import com.marcing.marcing.dto.RegisterRequest;
import com.marcing.marcing.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Long> login(
            @RequestBody LoginRequest loginRequest) {

        return ResponseEntity.ok(userService.login(loginRequest));
    }

//    @GetMapping("/getMyProject")
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<Project> chooseProject(
//            @RequestBody Long userId) {
//        log.info("Logging...");
//
//        Project project = projectService.getUserChosenProject(userId);
//        return ResponseEntity.ok(project);
//    }
    @PostMapping("/register")
    public ResponseEntity<Long> registerUser(@RequestBody RegisterRequest registerRequest){
        return ResponseEntity.ok(userService.register(registerRequest));
    }

}
