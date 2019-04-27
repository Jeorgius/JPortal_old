package com.jeorgius.front.rest.media.rest;

import com.jeorgius.front.rest.media.StorageService;
import com.jeorgius.front.rest.media.paths.Content;
import com.jeorgius.front.rest.media.paths.FilePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class SaveMedia {

    private StorageService storageService;
    private String root; //'D:\Programming\files\'
    public SaveMedia(){}

    @Autowired
    public SaveMedia(StorageService storageService,
                     @Value("${media.path}") String root) {
        this.storageService = storageService;
        this.root = root;
    }

    @PostMapping(value = "/admin/news/save_image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Map newsImage(@RequestParam("hero") MultipartFile newImage) throws IOException {
        storageService.store(newImage,
            new FilePath(root)
                .setContent(Content.NEWS)
                .setTMP(true)
                //.setUserId()
                //.setId()
                .setIndex(newImage.getOriginalFilename())
                .build()
        );

        Map<String,String> answer = new HashMap<>();
        answer.put("answer","Success");
        return answer;
    }

    @PostMapping(value = "/admin/music/save_image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Map musicImage(@RequestParam("hero") MultipartFile newImage) throws IOException {
        storageService.store(newImage, new FilePath(root)
            .setContent(Content.MUSIC)
            .setTMP(true)
            //.setUserId()
            //.setId()
            .setIndex(newImage.getOriginalFilename())
            .build());

        Map<String,String> answer = new HashMap<>();
        answer.put("answer","Success");
        return answer;
    }

    @PostMapping(value = "/admin/photos/save_image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Map photosImage(@RequestParam("hero") MultipartFile newImage) throws IOException {
        storageService.store(newImage, new FilePath(root)
            .setContent(Content.NEWS)
            .setTMP(true)
            //.setUserId()
            //.setId()
            .setIndex(newImage.getOriginalFilename())
            .build());

        Map<String,String> answer = new HashMap<>();
        answer.put("answer","Success");
        return answer;
    }

    @PostMapping(value = "/admin/store/save_image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Map storeImage(@RequestParam("hero") MultipartFile newImage) throws IOException {
        storageService.store(newImage, new FilePath(root)
            .setContent(Content.STORE)
            .setTMP(true)
            //.setUserId()
            //.setId()
            .setIndex(newImage.getOriginalFilename())
            .build());

        Map<String,String> answer = new HashMap<>();
        answer.put("answer","Success");
        return answer;
    }

    @PostMapping(value = "/users/save_image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Map usersImage(@RequestParam("hero") MultipartFile newImage) throws IOException {
        storageService.store(newImage, new FilePath(root)
            .setContent(Content.USERS)
            .setTMP(true)
            //.setUserId()
            //.setId()
            .setIndex(newImage.getOriginalFilename())
            .build());

        Map<String,String> answer = new HashMap<>();
        answer.put("answer","Success");
        return answer;
    }

    @PostMapping(value = "/admin/about/save_image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Map aboutImage(@RequestParam("hero") MultipartFile newImage) throws IOException {
        storageService.store(newImage, new FilePath(root)
            .setContent(Content.ABOUT)
            .setTMP(true)
            //.setUserId()
            //.setId()
            .setIndex(newImage.getOriginalFilename())
            .build());

        Map<String,String> answer = new HashMap<>();
        answer.put("answer","Success");
        return answer;
    }
}
