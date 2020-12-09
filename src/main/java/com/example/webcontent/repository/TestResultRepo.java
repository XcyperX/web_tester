package com.example.webcontent.repository;

import com.example.webcontent.model.TestResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestResultRepo extends JpaRepository<TestResult, Long> {
    List<TestResult> findAllByStudentId(Long studentId);
}
