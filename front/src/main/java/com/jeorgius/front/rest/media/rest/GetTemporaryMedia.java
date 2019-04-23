package com.jeorgius.front.rest.media.rest;

import com.jeorgius.front.rest.media.paths.Content;
import com.jeorgius.front.rest.media.paths.FilePathGenerator;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.filefilter.WildcardFileFilter;
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
public class TemporaryMedia {

    private FilePathGenerator pathGenerator;

    @Autowired
    public TemporaryMedia(FilePathGenerator pathGenerator) {
        this.pathGenerator = pathGenerator;
    }

    @GetMapping("/files/tmp/news/{index}")
    public ResponseEntity<byte[]> newsImage(@PathVariable String index) throws IOException {
        return new ResponseEntity<>(
            IOUtils.toByteArray(new FileInputStream(
                //@ToDo use directory with adminID
                pathGenerator.getFile(Content.NEWS.isTMP(true), index)
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
                pathGenerator.getFile(Content.MUSIC.isTMP(true), index)
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
                pathGenerator.getFile(Content.PHOTOS.isTMP(true), index)
            )),
            new HttpHeaders(),
            HttpStatus.OK
        );
    }

    @GetMapping("/files/tmp/photos/{index}")
    public ResponseEntity<byte[]> storeImage(@PathVariable String index) throws IOException {
        return new ResponseEntity<>(
            IOUtils.toByteArray(new FileInputStream(
                //@ToDo use directory with adminID
                pathGenerator.getFile(Content.STORE.isTMP(true), index)
            )),
            new HttpHeaders(),
            HttpStatus.OK
        );
    }

    @GetMapping("/files/tmp/photos/{index}")
    public ResponseEntity<byte[]> aboutImage(@PathVariable String index) throws IOException {
        return new ResponseEntity<>(
            IOUtils.toByteArray(new FileInputStream(
                //@ToDo use directory with adminID
                pathGenerator.getFile(Content.ABOUT.isTMP(true), index)
            )),
            new HttpHeaders(),
            HttpStatus.OK
        );
    }
}
