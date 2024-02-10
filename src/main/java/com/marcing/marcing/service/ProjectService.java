package com.marcing.marcing.service;

import com.marcing.marcing.model.Project;
import com.marcing.marcing.model.User;
import com.marcing.marcing.repository.ProjectRepository;
import com.marcing.marcing.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public void chooseProject(Long id, Long userId) {
        Optional<User> user = userRepository.findById(userId);
        Optional<Project> project = projectRepository.findById(id);
        if (user.isPresent() && project.isPresent()) {
            user.get().setProject(project.get());
            project.get().setIsActive(false);
            projectRepository.save(project.get());
            userRepository.save(user.get());
        }
    }

    public Project getUserChosenProject(Long userId) {
        Optional<User> user = userRepository.findById(userId);

        if (user.isPresent()) {
            return user.get().getProject();
        }

        return null;
    }
}
