package com.example.webcontent.repository;

import com.example.webcontent.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepo extends JpaRepository<Test, Long> {
}
