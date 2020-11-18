package com.example.webcontent.repository;

import com.example.webcontent.model.TestResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestResultRepo extends JpaRepository<TestResult, Long> {
}
