package com.jeorgius.front.rest.media.rest;

import com.jeorgius.front.rest.media.StorageService;
import com.jeorgius.front.rest.media.paths.Content;
import com.jeorgius.front.rest.media.paths.FilePath;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.IOException;

@RestController
public class CommonMedia {

    private StorageService storageService;

    @Autowired
    public CommonMedia(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/files/photos/{id}/{index}")
    public ResponseEntity<byte[]> photosImage(
        @PathVariable String index,
        @PathVariable String id
    ) throws IOException {
        return new ResponseEntity<>(
            IOUtils.toByteArray(new FileInputStream(
                storageService.getFile(new FilePath()
                    .setContent(Content.PHOTOS)
                    //.setUserId()
                    .setId(id)
                    .build()
                    ,index
                )
            )),
            new HttpHeaders(),
            HttpStatus.OK
        );
    }

    @GetMapping("/files/news/{id}/{index}")
    public ResponseEntity<byte[]> newsImage(
        @PathVariable String index,
        @PathVariable String id
    ) throws IOException {
        return new ResponseEntity<>(
            IOUtils.toByteArray(new FileInputStream(
                storageService.getFile(new FilePath()
                    .setContent(Content.NEWS)
                    //.setUserId()
                    .setId(id)
                    .build()
                    ,index
                )
            )),
            new HttpHeaders(),
            HttpStatus.OK
        );
    }

    @GetMapping("/files/store/{id}/{index}")
    public ResponseEntity<byte[]> storeImage(
        @PathVariable String index,
        @PathVariable String id
    ) throws IOException {
        return new ResponseEntity<>(
            IOUtils.toByteArray(new FileInputStream(
                storageService.getFile(new FilePath()
                    .setContent(Content.STORE)
                    //.setUserId()
                    .setId(id)
                    .build()
                    ,index
                )
            )),
            new HttpHeaders(),
            HttpStatus.OK
        );
    }

    @GetMapping("/files/users/{id}/{index}")
    public ResponseEntity<byte[]> usersImage(
        @PathVariable String index,
        @PathVariable String id
    ) throws IOException {
        return new ResponseEntity<>(
            IOUtils.toByteArray(new FileInputStream(
                storageService.getFile(new FilePath()
                    .setContent(Content.STORE)
                    //.setUserId()
                    .setId(id)
                    .build()
                    ,index
                )
            )),
            new HttpHeaders(),
            HttpStatus.OK
        );
    }

    @GetMapping("/files/about/{id}/{index}")
    public ResponseEntity<byte[]> aboutImage(
        @PathVariable String index,
        @PathVariable String id
    ) throws IOException {
        return new ResponseEntity<>(
            IOUtils.toByteArray(new FileInputStream(
                storageService.getFile(new FilePath()
                    .setContent(Content.STORE)
                    //.setUserId()
                    .setId(id)
                    .build()
                    ,index)
            )),
            new HttpHeaders(),
            HttpStatus.OK
        );
    }
}
