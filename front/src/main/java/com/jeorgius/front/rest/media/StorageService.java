package com.jeorgius.front.rest.media;

import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service
public class StorageService {

    private String root; //'D:\Programming\files\'

    @Autowired
    public StorageService(@Value("${media.path}") String root) {
        this.root = root;
    }

    public String store(MultipartFile uploadedFile, String filePath) throws IOException {
        InputStream in = uploadedFile.getInputStream();
        //save with index at built path
        OutputStream out = new FileOutputStream(
            new File(root+filePath
                +uploadedFile.getOriginalFilename()
        ));

        if(!new File(root+filePath).exists())
            new File(root+filePath).getParentFile().mkdirs();

        int read;
        byte[] bytes = new byte[1024];

        while ((read = in.read(bytes)) != -1) out.write(bytes,0,read);
        out.close();

        return "Success: file has been uploaded";
    }

    public File getFile(String filePath, String index){
        try {
            return new File(root+filePath)
                .listFiles((FileFilter) new WildcardFileFilter(index+".*"))[0];
        } catch (NullPointerException e){
            return new File(root+"image.svg");
        }
    }
}
