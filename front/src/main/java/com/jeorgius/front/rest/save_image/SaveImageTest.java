package com.jeorgius.front.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
public class SaveImageTest {
    @PostMapping(value = "/save_image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Map saveImage(@RequestParam("hero") MultipartFile newImage){

    }
}
