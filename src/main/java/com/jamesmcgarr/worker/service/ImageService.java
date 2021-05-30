package com.jamesmcgarr.worker.service;

import com.jamesmcgarr.worker.entity.Image;
import com.jamesmcgarr.worker.entity.Job;
import com.jamesmcgarr.worker.repository.ImageRepository;
import com.jamesmcgarr.worker.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public Image store(MultipartFile file) throws IOException {
        return imageRepository.save(new Image(file.getBytes(), file.getOriginalFilename()));
    }
}
