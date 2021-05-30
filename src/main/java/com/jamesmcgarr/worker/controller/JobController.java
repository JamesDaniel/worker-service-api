package com.jamesmcgarr.worker.controller;

import com.jamesmcgarr.worker.entity.Job;
import com.jamesmcgarr.worker.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping(value = "api/v1/job/{id}/status", produces = "application/json", consumes = "application/json")
    public Job getJob(@PathVariable Long id, @AuthenticationPrincipal Jwt jwt) {
        System.out.println(jwt.getClaims());
        return jobService.getJobById(id).get(); // `RUNNING`,`SUCCESS`,`FAILED`
    }

    @PostMapping(value = "api/v1/job", produces = "application/json", consumes = "application/json")
    public Job addJob(@RequestBody String request, @AuthenticationPrincipal Jwt jwt, HttpServletResponse response) {
        return jobService.addJob(new Job(
                jwt.getClaim("tid"),
                jwt.getClaim("oid"),
                "payloadLocation",
                1234L));
    }
}
