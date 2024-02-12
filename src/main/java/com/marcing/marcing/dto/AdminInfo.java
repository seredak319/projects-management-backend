package com.marcing.marcing.dto;

import com.marcing.marcing.model.Project;
import com.marcing.marcing.model.User;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class AdminInfo {

    List<User> users;
    List<Project> projects;
}
