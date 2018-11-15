package com.jeorgius.display_content.Controller.RestEntities.Display;

import com.jeorgius.cfg.Entities.GalleryItem;
import com.jeorgius.cfg.Entities.GalleryItemFull;

public class FullGallery {
    private Long id;
    private String title;
    private String filename;
    private String description;

    public FullGallery() {
    }

    public FullGallery(GalleryItem galleryItem, GalleryItemFull galleryItemFull) {
        this.id = galleryItem.getId();
        this.title = galleryItemFull.getTitle();
        this.filename = galleryItem.getFilename();
        this.description = galleryItemFull.getDescription();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
