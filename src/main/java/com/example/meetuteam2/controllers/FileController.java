package com.example.meetuteam2.controllers;

import com.example.meetuteam2.services.FileStorageService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
private FileStorageService fileStorageService;
    @PostMapping("/local/upload")
    public ResponseEntity<String> uploadFile(@RequestParam MultipartFile file) throws IOException {
        return ResponseEntity.ok(fileStorageService.upload(file));
    }

    @GetMapping("/local/download")
    public @ResponseBody ResponseEntity<byte[]> download(@RequestParam String fileName,
                                                         HttpServletResponse response) throws IOException {
        return ResponseEntity.ok(fileStorageService.download(fileName,response));
    }

    @PostMapping("/firebase/upload")
    public String uploadFireBase(@RequestParam("file") MultipartFile multipartFile) {
        return fileStorageService.uploadFirebase(multipartFile);
    }

    @GetMapping("/firebase/download")
    public ResponseEntity<byte[]> downloadFireBase(@RequestParam String file,
                                   HttpServletResponse response) throws IOException {
        return ResponseEntity.ok(fileStorageService.downloadFireBase(file,response));
    }
}