package com.jamesmcgarr.worker.repository;

import com.jamesmcgarr.worker.entity.Job;
import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<Job, Long> {


}
