package com.marcing.marcing.controller;

import com.marcing.marcing.model.Project;
import com.marcing.marcing.service.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Project> getAllProjects() {
        log.info("Get all projects");

        return projectService.getAllProjects();
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> chooseProject(
            @PathVariable Long id,
            @RequestParam(name = "userId") Long userId) {
        log.info("Choose project with id: {} for user with id: {}", id, userId);

        projectService.chooseProject(id, userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getMyProject")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Project> getMyProject(
            @RequestParam(name = "userId") Long userId) {
        log.info("Get my project for user with id = {}", userId);

        Project project = projectService.getUserChosenProject(userId);
        return ResponseEntity.ok(project);
    }

    @PostMapping("/cancel/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> deleteProject(
            @PathVariable Long id,
            @RequestParam(name = "userId") Long userId) {
        log.info("Delete project for user with id: {}", userId);

        projectService.unchooseProject(id, userId);
        return ResponseEntity.noContent().build();
    }
}
