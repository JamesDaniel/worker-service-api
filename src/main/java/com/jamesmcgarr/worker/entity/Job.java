package com.jamesmcgarr.worker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Job {
    @Id
    @GeneratedValue
    private Long id;
    private String tenentId;
    private String clientId;
    private String payloadLocation;
    private Long payloadSize;

    public Job(String tenentId, String clientId, String payloadLocation, Long payloadSize) {
        this.tenentId = tenentId;
        this.clientId = clientId;
        this.payloadLocation = payloadLocation;
        this.payloadSize = payloadSize;
    }
}
