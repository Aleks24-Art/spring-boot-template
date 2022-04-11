package com.example.template.controller;

import com.example.template.aspect.Loggable;
import com.example.template.dto.TestDto;
import com.example.template.entity.TestEntity;
import com.example.template.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    private final TestService testService;

    @GetMapping("/health-check")
    public String healthCheck() {
        return "Service working...";
    }

    @Loggable
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public TestEntity saveTestEntity(@RequestBody TestEntity entity) {
        return testService.save(entity);
    }

    @Loggable
    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public List<TestEntity> getAllTestEntities() {
        return testService.findAll();
    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TestEntity findById(@PathVariable UUID id) {
        return testService.findById(id);
    }
}
