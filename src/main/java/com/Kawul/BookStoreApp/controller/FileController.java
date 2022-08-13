package com.Kawul.BookStoreApp.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@CrossOrigin(origins ="*")
@RequestMapping("/file")
@RestController
public class FileController {

    private static final String UPLOADED_FOLDER = System.getProperty("user.dir") + "/src/main/resources/static";


    @PostMapping("/upload")
    public String  singleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {

        return ( saveFile(file));
    }

    private String saveFile(MultipartFile file) throws IOException {
        Path path = Paths.get(UPLOADED_FOLDER + "/" + file.getOriginalFilename());
        file.transferTo(path);
        return "http:// 192.168.1.15:8080" + "/" + file.getOriginalFilename() + "/";
    }


}