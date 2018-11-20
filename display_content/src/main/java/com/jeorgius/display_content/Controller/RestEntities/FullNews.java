package com.jeorgius.display_content.Controller.RestEntities;

import com.jeorgius.database.Entities.NewsItem;
import com.jeorgius.database.Entities.NewsItemFull;

public class FullNews {
    private Long id;
    private String title;
    private String fullText;
    private String filename;

    public FullNews(){}
    public FullNews(NewsItem newsItem, NewsItemFull newsItemFull){
        this.id = newsItem.getId();
        this.title = newsItem.getTitle();
        this.filename = newsItem.getFilename();
        this.fullText = newsItemFull.getFullText();
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

    public String getFullText() {
        return fullText;
    }

    public void setFullText(String fullText) {
        this.fullText = fullText;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
