package com.marcing.marcing.repository;


import com.marcing.marcing.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
