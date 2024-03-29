package com.marcing.marcing.service;

import com.marcing.marcing.dto.ProjectRequest;
import com.marcing.marcing.model.Project;
import com.marcing.marcing.model.User;
import com.marcing.marcing.repository.ProjectRepository;
import com.marcing.marcing.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        if (user.isPresent() && project.isPresent() && (user.get().getProject() == null)) {
            user.get().setProject(project.get());
            project.get().setIsActive(false);
            project.get().setTimestamp(LocalDateTime.now());
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

    public void unchooseProject(Long id, Long userId) {
        Optional<User> user = userRepository.findById(userId);
        Optional<Project> project = projectRepository.findById(id);
        if (user.isPresent() && project.isPresent() && user.get().getProject() != null) {
            user.get().setProject(null);
            userRepository.save(user.get());
            project.get().setIsActive(true);
            project.get().setTimestamp(null);
            projectRepository.save(project.get());
        }
    }

    public void deleteProject(Long id) {
        Optional<Project> project = projectRepository.findById(id);
        if (project.isPresent()) {
            projectRepository.deleteById(id);
        }
    }

    public Project editProject(Long id, ProjectRequest projectRequest) {
        Project project = new Project(id, projectRequest.getTitle(), projectRequest.getText(), projectRequest.getIsActive(), null);
        projectRepository.save(project);
        return project;
    }

    public void createProject(ProjectRequest projectRequest) {
        Project project = Project.builder()
                .title(projectRequest.getTitle())
                .text(projectRequest.getText())
                .isActive(true)
                .build();
        projectRepository.save(project);
    }
}
