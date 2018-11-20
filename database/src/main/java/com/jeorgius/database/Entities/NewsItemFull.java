package com.jeorgius.database.Entities;

import javax.persistence.*;

@Entity
@Table(name = "news_items", schema = "common")
public class NewsItemFull {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullText;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private NewsItem newsItem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullText() {
        return fullText;
    }

    public void setFullText(String fullText) {
        this.fullText = fullText;
    }

    public NewsItem getNewsItem() {
        return newsItem;
    }

    public void setNewsItem(NewsItem newsItem) {
        this.newsItem = newsItem;
    }
}
