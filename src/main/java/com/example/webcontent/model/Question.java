package com.example.webcontent.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "questions")
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    @OneToMany(mappedBy = "question", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Answer> answers;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "test_id", referencedColumnName = "id")
    private Test test;
}
