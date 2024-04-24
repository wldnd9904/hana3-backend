package com.study.ex26_fileupload;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Service
public class UploadService {
    // application.properties 의 내용 가져와서 주입
    @Value("${spring.servlet.multipart.location}")
    private String CKImageFolder;
    @Value("/upload/")
    private String ckImagePath;


    public CKResponse ckImageUpload(MultipartFile image) {
        if (image != null && !image.isEmpty()) {
            String imageName = UUID.randomUUID() + "_" + image.getOriginalFilename();
            File file = new File(CKImageFolder, imageName);
            try {
                image.transferTo(file);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new CKResponse(1, imageName, ckImagePath + imageName);
        }
        return null;
    }
}