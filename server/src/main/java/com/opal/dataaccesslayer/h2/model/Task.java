package com.opal.dataaccesslayer.h2.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Task")
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TASK_NAME")
    private String name;
}
