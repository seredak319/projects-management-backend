package com.marcing.marcing.service;

import com.marcing.marcing.dto.AdminInfo;
import com.marcing.marcing.repository.ProjectRepository;
import com.marcing.marcing.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    public AdminInfo getAdminInfo() {
        return AdminInfo.builder()
                .projects(projectRepository.findAll())
                .users(userRepository.findAll())
                .build();
    }
}
