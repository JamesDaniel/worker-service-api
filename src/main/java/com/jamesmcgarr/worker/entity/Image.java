package com.jamesmcgarr.worker.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
@NoArgsConstructor
@Data
public class Image {

    @Id
    @GeneratedValue
    Long id;

    @Lob
    byte[] content;

    String name;

    public Image(byte[] content, String name) {
        this.content = content;
        this.name = name;
    }
}