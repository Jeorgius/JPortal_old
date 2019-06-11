package com.jeorgius.lib.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "news", schema = "common")
public class NewsItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String preText;
    private String filename;

    @JsonManagedReference
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private NewsItemFull newsItemFull;

    public NewsItem(){}


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPreText() {
        return preText;
    }

    public void setPreText(String preText) {
        this.preText = preText;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public NewsItemFull getNewsItemFull() {
        return newsItemFull;
    }

    public void setNewsItemFull(NewsItemFull newsItemFull) {
        this.newsItemFull = newsItemFull;
    }

    public NewsItem(String title, String preText, String filename, NewsItemFull newsItemFull) {
        this.title = title;
        this.preText = preText;
        this.filename = filename;
        this.newsItemFull = newsItemFull;
    }
}
