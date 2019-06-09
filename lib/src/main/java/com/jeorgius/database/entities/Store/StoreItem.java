package com.jeorgius.database.entities.Store;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name="store", schema = "store")
public class StoreItem {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String pn;
    private Integer price;
    private Integer quantity;
    private boolean hotsale;
    private String hero;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private StoreItemFull storeItemFull;

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

    public String getHero() {
        return hero;
    }

    public void setHero(String hero) {
        this.hero = hero;
    }

    public StoreItemFull getStoreItemFull() {
        return storeItemFull;
    }

    public void setStoreItemFull(StoreItemFull storeItemFull) {
        this.storeItemFull = storeItemFull;
    }
}
