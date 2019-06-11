package com.jeorgius.display_content.Controller.RestEntities;

import com.jeorgius.lib.entities.Store.ItemFeature;
import com.jeorgius.lib.entities.Store.StoreGalleryItem;
import com.jeorgius.lib.entities.Store.StoreItem;
import com.jeorgius.lib.entities.Store.StoreItemFull;

import java.util.List;

public class FullStoreItem {
    private Long id;
    private String title;
    private String pn;
    private String hero_image;
    private Integer price;
    private Integer quantity;
    private boolean hotsale;
    private List<ItemFeature> features;
    private List<StoreGalleryItem> gallery;
    private String description;

    public FullStoreItem(){}
    public FullStoreItem(StoreItem storeItem, StoreItemFull storeItemFull){
        this.id = storeItem.getId();
        this.title = storeItem.getTitle();
        this.pn = storeItem.getPn();
        this.hero_image = storeItemFull.getHero_filename();
        this.price = storeItem.getPrice();
        this.quantity = storeItem.getQuantity();
        this.hotsale = storeItem.isHotsale();
        this.features = storeItemFull.getFeatures();
        this.gallery = storeItemFull.getGallery();
        this.description = storeItemFull.getDescription();
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

    public String getPn() {
        return pn;
    }

    public void setPn(String pn) {
        this.pn = pn;
    }

    public String getHero_image() {
        return hero_image;
    }

    public void setHero_image(String hero_image) {
        this.hero_image = hero_image;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public boolean isHotsale() {
        return hotsale;
    }

    public void setHotsale(boolean hotsale) {
        this.hotsale = hotsale;
    }

    public List<ItemFeature> getFeatures() {
        return features;
    }

    public void setFeatures(List<ItemFeature> features) {
        this.features = features;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<StoreGalleryItem> getGallery() {
        return gallery;
    }

    public void setGallery(List<StoreGalleryItem> gallery) {
        this.gallery = gallery;
    }
}
