package com.jeorgius.database.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "gallery", schema = "common")
public class GalleryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String filename;

    @JsonManagedReference
    @OneToOne(fetch = FetchType.LAZY)
    private GalleryItemFull galleryItemFull;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public GalleryItemFull getGalleryItemFull() {
        return galleryItemFull;
    }

    public void setGalleryItemFull(GalleryItemFull galleryItemFull) {
        this.galleryItemFull = galleryItemFull;
    }
}
