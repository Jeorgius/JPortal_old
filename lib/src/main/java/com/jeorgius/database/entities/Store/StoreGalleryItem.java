package com.jeorgius.database.entities.Store;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name="gallery", schema="store")
public class StoreGalleryItem {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String file_path;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="storeItemFullId")
    private StoreItemFull storeItemFull;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public StoreItemFull getStoreItemFull() {
        return storeItemFull;
    }

    public void setStoreItemFull(StoreItemFull storeItemFull) {
        this.storeItemFull = storeItemFull;
    }
}
