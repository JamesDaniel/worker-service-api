package com.jamesmcgarr.worker.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class JobController {

    @GetMapping(value = "api/v1/job/{id}/status", produces = "application/json", consumes = "application/json")
    public String test(@PathVariable int id) {
        return "test response " + id;
    }

    @PostMapping(value = "api/v1/job", produces = "application/json", consumes = "application/json")
    public String test(@RequestBody String request, HttpServletResponse response) {
        return request;
    }
}
