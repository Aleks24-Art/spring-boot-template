package com.example.template.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    @GetMapping("/api/v1/health-check")
    public String healthCheck() {
        return "Service working...";
    }
}
