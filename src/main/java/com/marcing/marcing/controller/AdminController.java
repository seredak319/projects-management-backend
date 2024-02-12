package com.marcing.marcing.controller;

import com.marcing.marcing.dto.AdminInfo;
import com.marcing.marcing.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/getAdminInfo")
    @ResponseStatus(HttpStatus.OK)
    public AdminInfo getAllProjects() {
        log.info("Get admin info");
        return adminService.getAdminInfo();
    }
}
