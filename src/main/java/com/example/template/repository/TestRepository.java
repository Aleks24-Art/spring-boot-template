package com.example.template.repository;

import com.example.template.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TestRepository extends JpaRepository<TestEntity, UUID> {
}
