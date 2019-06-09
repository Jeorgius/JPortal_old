package com.jeorgius.database.entities.Store;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name="store_item_full", schema="store")
public class StoreItemFull {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String hero_filename;

    @JsonManagedReference
    @OneToMany(mappedBy = "storeItemFull", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<StoreGalleryItem> gallery;

    @JsonBackReference
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private StoreItem storeItem;

    @JsonManagedReference
    @OneToMany(mappedBy = "storeItemFull", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ItemFeature> features;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHero_filename() {
        return hero_filename;
    }

    public void setHero_filename(String hero_filename) {
        this.hero_filename = hero_filename;
    }

    public StoreItem getStoreItem() {
        return storeItem;
    }

    public void setStoreItem(StoreItem storeItem) {
        this.storeItem = storeItem;
    }

    public List<ItemFeature> getFeatures() {
        return features;
    }

    public void setFeatures(List<ItemFeature> features) {
        this.features = features;
    }

    public List<StoreGalleryItem> getGallery() {
        return gallery;
    }

    public void setGallery(List<StoreGalleryItem> gallery) {
        this.gallery = gallery;
    }
}
