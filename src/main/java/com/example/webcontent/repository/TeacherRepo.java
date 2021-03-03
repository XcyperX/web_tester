package com.example.webcontent.repository;

import com.example.webcontent.model.Role;
import com.example.webcontent.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TeacherRepo extends JpaRepository<Teacher, Long> {
    Optional<Teacher> findByEmail(String name);
    List<Teacher> findAllByRole(Role role);
}
