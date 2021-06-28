package com.project.springbootproject.service;

import com.project.springbootproject.dto.GalleryDto;
import com.project.springbootproject.repository.GalleryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FileService {
    private GalleryRepository galleryRepository;

    public void savePost(GalleryDto galleryDto) {
        galleryRepository.save(galleryDto.toEntity());
    }
}
