package com.example.webcontent.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "results_tests")
@Data
public class TestResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "test_id", referencedColumnName = "id")
    private Test test;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @Column(nullable = false)
    private Integer result;
}
