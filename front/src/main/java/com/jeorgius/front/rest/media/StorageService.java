package com.jeorgius.front.rest.media;

import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service
public class StorageService {

    public String store(MultipartFile uploadedFile, String filePath) throws IOException {
        InputStream in = uploadedFile.getInputStream();
        //save with index at built path
        OutputStream out = new FileOutputStream(
            new File(filePath
                +uploadedFile.getOriginalFilename()
        ));

        if(!new File(filePath).exists())
            new File(filePath).getParentFile().mkdirs();

        int read;
        byte[] bytes = new byte[1024];

        while ((read = in.read(bytes)) != -1) out.write(bytes,0,read);
        out.close();

        return "Success: file has been uploaded";
    }

    public File getFile(String filePath, String index){
        return new File(filePath)
            .listFiles((FileFilter) new WildcardFileFilter(index+".*"))[0];
    }
}
