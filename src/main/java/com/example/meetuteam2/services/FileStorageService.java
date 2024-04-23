package com.example.meetuteam2.services;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileStorageService {
    @Value("${fileDirectory}")
    private String directory;
    @Value("${fileDirectory}")
    private String fireBaseDirectory;


    /**
     * questo metodo fa upload di un file immagine da usare come immagine del profilo
     * @param file
     * @return una stringa, ovvero il path del file in locale (per ora)
     * @throws IOException
     */
    public String upload(MultipartFile file) throws IOException {
        //prendo il nome del file
        String fileString = file.getOriginalFilename();
        //prendo l'estensione del file
        String extension = FilenameUtils.getExtension(fileString);
        //creo un nuovo nome randomizzto
        String randomFileName = UUID.randomUUID().toString();
        //creo un nuovo nome completo del file
        String completedName = randomFileName + "." + extension;
        //creo un nuovo oggetto File con la directory
        File fileDirectory = new File(directory);
        //controllo che la directory data esista
        if (!fileDirectory.exists()) {
            throw new IOException("directory doesn't exists");
        }
        //controllo che il path dato porti ad una directory
        if (!fileDirectory.isDirectory()) {
            throw new IOException("the path given is not a directory");
        }
        //creo un nuovo oggetto file dove dovrà essere salvata il nostro file
        File directorySavedFile = new File(directory + File.separator + completedName);
        //controllo che non esista già un file con il medesimo nome
        if (directorySavedFile.exists()) {
            throw new IOException("file already present");
        }
        //trasferisco il file nella directory locale
        file.transferTo(directorySavedFile);
        //ritorno il nome del file salvato
        return completedName;
    }

    public byte[] download(String fileName, HttpServletResponse response) throws IOException {
        //prendiamo l'estensione del file
        String extension = FilenameUtils.getExtension(fileName);
        //effettuiamo un controllo sull'estensione per dare alla response il tipo corretto
        switch (extension) {
            case "jpg", "jpeg":
                //se jpg o jpeg setterà alla response il Media Type con valore JPEG
                response.setContentType(MediaType.IMAGE_JPEG_VALUE);
                break;
            case "png":
                //se png setterà alla response il Media Type con valore PNG
                response.setContentType(MediaType.IMAGE_PNG_VALUE);
                break;
            case "gif":
                //se gif setterà alla response il Media Type con valore GIF
                response.setContentType(MediaType.IMAGE_GIF_VALUE);
                break;
        }
        response.setHeader("Content-Disposition", "attachment; filename = \"" + fileName + "\"");
        //dato il fileName lo recupera dalla directory
        File file = new File(directory + File.separator + fileName);
        //se non esiste viene laciato un IOException
        if (!file.exists()) {
            throw new IOException();
        }
        //ritorna convertito in Byte il file desiderato
        return IOUtils.toByteArray(new FileInputStream(file));
    }

    private String uploadFile(File file, String fileName) throws IOException {
        BlobId blobId = BlobId.of("file-storage-meetuat.appspot.com", fileName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("media").build();
        Credentials credentials = GoogleCredentials.fromStream(new FileInputStream(fireBaseDirectory));
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
        storage.create(blobInfo, Files.readAllBytes(file.toPath()));
        return String.format("https://firebasestorage.googleapis.com/v0/b/file-storage-meetuat.appspot.com/o/%s?alt=media", URLEncoder.encode(fileName, StandardCharsets.UTF_8));
    }

    private File convertToFile(MultipartFile multipartFile, String fileName) throws IOException {
        File tempFile = new File(fileName);
        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
            fos.write(multipartFile.getBytes());
            fos.close();
        }
        return tempFile;
    }

    public String uploadFirebase(MultipartFile multipartFile) {
        try {
            String fileName = multipartFile.getOriginalFilename();
            String extension = FilenameUtils.getExtension(fileName);    // to get original file name
            fileName = UUID.randomUUID().toString().concat(extension);  // to generated random string values for file name.

            File file = this.convertToFile(multipartFile, fileName);                      // to convert multipartFile to File
            String TEMP_URL = this.uploadFile(file, fileName);                            // to get uploaded file link
            file.delete();                                                                // to delete the copy of uploaded file stored in the project folder
            return TEMP_URL;
        } catch (Exception e) {
            e.printStackTrace();
            return "Unsuccessfully Uploaded!";
        }

    }

    public byte[] downloadFireBase(String fileName,HttpServletResponse response) throws IOException {
        String extension = FilenameUtils.getExtension(fileName);
        switch (extension) {
            case "jpg", "jpeg":
                response.setContentType(MediaType.IMAGE_JPEG_VALUE);
                break;
            case "png":
                response.setContentType(MediaType.IMAGE_PNG_VALUE);
                break;
            case "gif":
                response.setContentType(MediaType.IMAGE_GIF_VALUE);
                break;
        }
        response.setHeader("Content-Disposition", "attachment; filename = \"" + fileName + "\"");
        String destFileName = UUID.randomUUID().toString().concat(extension);
        Credentials credentials = GoogleCredentials.fromStream(new FileInputStream(fireBaseDirectory));
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
        Blob blob = storage.get(BlobId.of("file-storage-meetuat.appspot.com", fileName));

        return blob.getContent();
    }
}
