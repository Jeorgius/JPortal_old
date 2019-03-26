package com.jeorgius.front.rest.save_image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class SaveImageTest {

    private StorageService storageService;

    @Autowired
    public SaveImageTest(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping(value = "/save_image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Map saveImage(@RequestParam("hero") MultipartFile newImage) throws IOException {
        storageService.store(newImage);

        Map<String,String> answer = new HashMap<>();
        answer.put("answer","Success");
        return answer;
    }
}
