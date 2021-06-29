package com.project.springbootproject.controller;

import com.project.springbootproject.dto.GalleryDto;
import com.project.springbootproject.service.FileService;
import com.project.springbootproject.service.S3Service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@AllArgsConstructor
public class FileController {
    private S3Service s3Service;
    private FileService fileService;

    @GetMapping("/gallery")
    public String dispFile (Model model) {
        List<GalleryDto> galleryDtoList = fileService.getList();

        model.addAttribute("galleryList", galleryDtoList);

        return "board/gallery";
    }

    @PostMapping("/gallery")
    public String execFile (GalleryDto galleryDto, MultipartFile file) throws IOException {
        String attachedFile = s3Service.upload(file);
        galleryDto.setFilePath(attachedFile);

        fileService.savePost(galleryDto);
        return "redirect:/gallery";
    }

}
