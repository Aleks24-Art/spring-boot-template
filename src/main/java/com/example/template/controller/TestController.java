package com.example.template.controller;

import com.example.template.dto.TestDto;
import com.example.template.entity.TestEntity;
import com.example.template.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TestController {

    private final TestRepository testRepository;

    @GetMapping("/health-check")
    public String healthCheck() {
        return "Service working...";
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public TestEntity saveTestEntity(@RequestBody TestDto dto) {
        return testRepository.save(new TestEntity(UUID.randomUUID(), dto.getName()));
    }

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public List<TestEntity> getAllTestEntities() {
        return testRepository.findAll();
    }
}
