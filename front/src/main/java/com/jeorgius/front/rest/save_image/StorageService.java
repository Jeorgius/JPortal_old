package com.jeorgius.front.rest.save_image;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service
public class StorageService {
    public String store(MultipartFile uploadedFile) throws IOException {
        InputStream in = uploadedFile.getInputStream();
        OutputStream out = new FileOutputStream(new File("D:\\Programming\\files\\"+uploadedFile.getName()));

        int read = 0;
        byte[] bytes = new byte[1024];

        while ((read = in.read(bytes)) != -1) out.write(bytes,0,read);
        out.close();

        return "Success: file has been uploaded";
    }
}
