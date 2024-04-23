package com.example.meetuteam2.controllers;

import com.example.meetuteam2.services.FileStorageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@Tag(name = "File", description = "Controller delle APIs per le immagini del profilo")
@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
private FileStorageService fileStorageService;

    @Operation(summary = "Carica un'immagine in locale per il profilo utente")
    @PostMapping("/local/upload")
    public ResponseEntity<String> uploadFile(@RequestParam MultipartFile file) throws IOException {
        return ResponseEntity.ok(fileStorageService.upload(file));
    }

    @Operation(summary = "Scarica l'immagine in locale del profilo")
    @GetMapping("/local/download")
    public @ResponseBody ResponseEntity<byte[]> download(@RequestParam String fileName,
                                                         HttpServletResponse response) throws IOException {
        return ResponseEntity.ok(fileStorageService.download(fileName,response));
    }

    @Operation(summary = "Carica un'immagine sul cloud FireBase per il profilo utente")
    @PostMapping("/firebase/upload")
    public String uploadFireBase(@RequestParam("file") MultipartFile multipartFile) {
        return fileStorageService.uploadFirebase(multipartFile);
    }

    @Operation(summary = "Scarica l'immagine del profilo dal cloud FireBase")
    @GetMapping("/firebase/download")
    public ResponseEntity<byte[]> downloadFireBase(@RequestParam String file,
                                   HttpServletResponse response) throws IOException {
        return ResponseEntity.ok(fileStorageService.downloadFireBase(file,response));
    }
}