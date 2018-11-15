package com.jeorgius.display_content.Controller.Logic;

import com.jeorgius.cfg.Entities.GalleryItem;
import com.jeorgius.cfg.Entities.NewsItem;
import com.jeorgius.cfg.Entities.Store.StoreItem;
import com.jeorgius.cfg.Entities.Users.User;
import com.jeorgius.cfg.Repos.GalleryRepo;
import com.jeorgius.cfg.Repos.NewsRepo;
import com.jeorgius.cfg.Repos.StoreRepo;
import com.jeorgius.cfg.Repos.UserRepo;
import com.jeorgius.display_content.Controller.RestEntities.Display.FullGallery;
import com.jeorgius.display_content.Controller.RestEntities.Display.FullNews;
import com.jeorgius.display_content.Controller.RestEntities.Display.FullStoreItem;
import com.jeorgius.display_content.Controller.RestEntities.Display.FullUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FullInfoDisplay {

    private ValidateInput vI;

    private UserRepo userRepo;
    private NewsRepo newsRepo;
    private GalleryRepo galleryRepo;
    private StoreRepo storeRepo;

    @Autowired
    public FullInfoDisplay(ValidateInput vI, UserRepo userRepo, NewsRepo newsRepo, GalleryRepo galleryRepo, StoreRepo storeRepo) {
        this.vI = vI;
        this.userRepo = userRepo;
        this.newsRepo = newsRepo;
        this.galleryRepo = galleryRepo;
        this.storeRepo = storeRepo;
    }

    public FullUser renderFullUser(String userId) {
        User user = userRepo.findOneById(vI.convertToLong(userId));
        // TODO CREDS VALIDATION
        if (user == null) return new FullUser();
        return new FullUser(user, user.getUserFull(), user.getUserPrivate());
    }

    public FullNews renderFullNews(String newsId) {
        NewsItem newsItem = newsRepo.findOneById(vI.convertToLong(newsId));
        if (newsItem == null) return new FullNews();
        return new FullNews(newsItem, newsItem.getNewsItemFull());
    }

    public FullStoreItem renderStoreItem(String itemId) {
        StoreItem item = storeRepo.findOneById(vI.convertToLong(itemId));
        if (item == null) return new FullStoreItem();
        return new FullStoreItem(item, item.getStoreItemFull());
    }

    public FullGallery renderFullGalleryItem(String id) {
        GalleryItem item = galleryRepo.findOneById(vI.convertToLong(id));
        if (item == null) return new FullGallery();
        return new FullGallery(item, item.getGalleryItemFull());
    }
}
