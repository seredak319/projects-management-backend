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
public class Project {

    @Id
    @GeneratedValue
    Long id;
    String title;
    String text;
    Boolean isActive;
}
