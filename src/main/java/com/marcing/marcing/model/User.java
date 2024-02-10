package com.marcing.marcing.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User {
    @Id
    @GeneratedValue
    Long userId;
    String email;
    String password;

    @OneToOne
    @JoinColumn(name = "project_id")
    private Project project;
}
