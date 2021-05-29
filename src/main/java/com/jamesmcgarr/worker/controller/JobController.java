package com.jamesmcgarr.worker.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class JobController {

    @GetMapping(value = "api/v1/job/{id}/status", produces = "application/json", consumes = "application/json")
    public String test(@PathVariable int id, @AuthenticationPrincipal Jwt jwt) {
        System.out.println(jwt.getClaims());
        System.out.println("-- " + jwt.getClaim("tid"));
        System.out.println("-- " + jwt.getClaim("oid"));
        System.out.println("-- " + jwt.getClaim("aud"));
        System.out.println("-- " + jwt.getClaim("azp"));
        System.out.println("-- " + jwt.getClaim("name"));
        System.out.println("-- " + jwt.getClaim("email"));
        return "test response " + id; // `RUNNING`,`SUCCESS`,`FAILED`
    }

    @PostMapping(value = "api/v1/job", produces = "application/json", consumes = "application/json")
    public String test(@RequestBody String request, HttpServletResponse response) {
        return request;
    }
}
