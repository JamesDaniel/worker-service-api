package com.jamesmcgarr.worker.controller;

import com.jamesmcgarr.worker.entity.Image;
import com.jamesmcgarr.worker.entity.Job;
import com.jamesmcgarr.worker.repository.ImageRepository;
import com.jamesmcgarr.worker.service.ImageService;
import com.jamesmcgarr.worker.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class JobController {

    @Autowired
    private JobService jobService;

    @Autowired
    private ImageService imageService;

    @GetMapping(value = "api/v1/job/{id}/status", produces = "application/json", consumes = "application/json")
    public Job getJob(@PathVariable Long id, @AuthenticationPrincipal Jwt jwt) {
        return jobService.getJobById(id).get(); // `RUNNING`,`SUCCESS`,`FAILED`
    }

    @PostMapping(value = "api/v1/job", produces = "application/json", consumes = "multipart/form-data")
    public Job addJob(@AuthenticationPrincipal Jwt jwt, @RequestParam("payload") MultipartFile payload) throws IOException {
        final Image savedImage = imageService.store(payload);
        return jobService.addJob(new Job(
                jwt.getClaim("tid"),
                jwt.getClaim("oid"),
                savedImage.getId().toString(),
                payload.getSize()));
    }
}
