package com.example.webcontent.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tests")
@Data
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @OneToMany(mappedBy = "test", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Question> questions;

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private Teacher owner;
}
