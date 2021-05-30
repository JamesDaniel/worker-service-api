package com.jamesmcgarr.worker.repository;

import com.jamesmcgarr.worker.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {


}
