package com.tines.sandbox.controller;

import com.tines.sandbox.service.TinesService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class HelloController {

    private final TinesService tinesService;

    public HelloController(TinesService tinesService) {
        this.tinesService = tinesService;
    }

    @GetMapping("/hello")
    public Map<String, String> getHello() {
        return Map.of("message", tinesService.getMessage());
    }
}

