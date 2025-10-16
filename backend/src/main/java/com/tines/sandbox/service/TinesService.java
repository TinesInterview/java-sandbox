package com.tines.sandbox.service;

import org.springframework.stereotype.Service;

@Service
public class TinesService {

    private static final String MESSAGE = "Welcome";

    public String getMessage() {
        return MESSAGE;
    }
}

