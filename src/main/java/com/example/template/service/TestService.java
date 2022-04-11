package com.example.template.service;

import com.example.template.aspect.Loggable;
import com.example.template.dto.TestDto;
import com.example.template.entity.TestEntity;
import com.example.template.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestRepository testRepository;

    @Loggable
    @CachePut(value = "testEntity", key = "#entity.id")
    @CacheEvict
    public TestEntity save(TestEntity entity) {
        return testRepository.save(entity);
    }

    public List<TestEntity> findAll() {
        return testRepository.findAll();
    }

    @Loggable
    @Cacheable(value = "testEntity", key = "#id")
    public TestEntity findById(UUID id) {
        return testRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

}
