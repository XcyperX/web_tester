package com.example.webcontent.repository;

import com.example.webcontent.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepo extends JpaRepository<Group, Long> {
    List<Group> findAllByTeacherId(Long id);
}
