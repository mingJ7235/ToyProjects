package com.project.springbootproject.controller;

import com.project.springbootproject.service.FileService;
import com.project.springbootproject.service.S3Service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class FileController {
    private S3Service s3Service;
    private FileService fileService;

    @GetMapping("/gallery")
    public String dispFile () {

        return "board/gallery";
    }

}
