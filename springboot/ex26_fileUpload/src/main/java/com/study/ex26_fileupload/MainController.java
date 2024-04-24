package com.study.ex26_fileupload;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final UploadService uploadService;

    @GetMapping("/")
    public String main() {
        return "upload";
    }

    @GetMapping("/ckeditor")
    public String ckeditor() {
        return "upload_ckeditor4";
    }


    @PostMapping("/upload")
    public String upload(@RequestParam MultipartFile[] uploadFile, Model model) throws IOException {
        List<FileDto> list = new ArrayList<>();
        for (MultipartFile file : uploadFile) {
            if (!file.isEmpty()) {
                //FileDto 정보 생성
                FileDto dto = new FileDto(UUID.randomUUID().toString(), file.getOriginalFilename(), file.getContentType());
                list.add(dto);

                File newFileName = new File(dto.uuid() + "_" + dto.fileName());
                //전달한 내용을 실제 파일로 저장
                file.transferTo(newFileName);
            }
        }
        model.addAttribute("files", list);
        return "result";
    }

    @PostMapping("/ckUpload")
    @ResponseBody
    public ResponseEntity<CKResponse> ckImageUpload(MultipartFile upload) {
        CKResponse ckResponse = uploadService.ckImageUpload(upload);
        return ResponseEntity.ok(ckResponse);
    }
}
