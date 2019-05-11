package com.jeorgius.front.rest.media.rest;

import com.jeorgius.front.rest.media.StorageService;
import com.jeorgius.front.rest.media.paths.Content;
import com.jeorgius.front.rest.media.paths.FilePath;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.IOException;

@RestController
public class GetTemporaryMedia {

    private StorageService storageService;
    private String root; //'D:\Programming\files\'
    public GetTemporaryMedia(){}

    @Autowired
    public GetTemporaryMedia(StorageService storageService,
                     @Value("${media.path}") String root) {
        this.storageService = storageService;
        this.root = root;
    }

    @GetMapping("/files/tmp/news/{index}")
    public ResponseEntity<byte[]> newsImage(@PathVariable String index) throws IOException {
        return new ResponseEntity<>(
            IOUtils.toByteArray(new FileInputStream(
                //@ToDo use directory with adminID
                storageService.getFile(new FilePath(this.root)
                    .setContent(Content.NEWS)
                    .setTMP(true)
                    //.setUserId()
                    //.setId(id)
                    .build(),
                    index
                )
            )),
            new HttpHeaders(),
            HttpStatus.OK
        );
    }

    @GetMapping("/files/tmp/music/{index}")
    public ResponseEntity<byte[]> musicImage(@PathVariable String index) throws IOException {
        return new ResponseEntity<>(
            IOUtils.toByteArray(new FileInputStream(
                //@ToDo use directory with adminID
                storageService.getFile(new FilePath(this.root)
                    .setContent(Content.MUSIC)
                    .setTMP(true)
                    //.setUserId()
                    //.setId()
                    .build(),
                    index
                )
            )),
            new HttpHeaders(),
            HttpStatus.OK
        );
    }

    @GetMapping("/files/tmp/photos/{index}")
    public ResponseEntity<byte[]> photosImage(@PathVariable String index) throws IOException {
        return new ResponseEntity<>(
            IOUtils.toByteArray(new FileInputStream(
                //@ToDo use directory with adminID
                storageService.getFile(new FilePath(this.root)
                    .setContent(Content.PHOTOS)
                    .setTMP(true)
                    //.setUserId()
                    //.setId()
                    .build(),
                    index
                )
            )),
            new HttpHeaders(),
            HttpStatus.OK
        );
    }

    @GetMapping("/files/tmp/store/{index}")
    public ResponseEntity<byte[]> storeImage(@PathVariable String index) throws IOException {
        return new ResponseEntity<>(
            IOUtils.toByteArray(new FileInputStream(
                //@ToDo use directory with adminID
                storageService.getFile(new FilePath(this.root)
                    .setContent(Content.STORE)
                    .setTMP(true)
                    //.setUserId()
                    //.setId()
                    .build(),
                    index
                )
            )),
            new HttpHeaders(),
            HttpStatus.OK
        );
    }

    @GetMapping("/files/tmp/about/{index}")
    public ResponseEntity<byte[]> aboutImage(@PathVariable String index) throws IOException {
        return new ResponseEntity<>(
            IOUtils.toByteArray(new FileInputStream(
                //@ToDo use directory with adminID
                storageService.getFile(new FilePath(this.root)
                    .setContent(Content.ABOUT)
                    .setTMP(true)
                    //.setUserId()
                    //.setId()
                    .build(),
                    index
                )
            )),
            new HttpHeaders(),
            HttpStatus.OK
        );
    }
}
