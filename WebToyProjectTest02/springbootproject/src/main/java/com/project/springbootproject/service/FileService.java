package com.project.springbootproject.service;

import com.project.springbootproject.domain.entity.GalleryEntity;
import com.project.springbootproject.dto.GalleryDto;
import com.project.springbootproject.repository.GalleryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class FileService {
    private GalleryRepository galleryRepository;

    public List<GalleryDto> getList () {
        List<GalleryEntity> galleryEntityList = galleryRepository.findAll();
        List<GalleryDto> galleryDtoList = new ArrayList<>();

        for (GalleryEntity galleryEntity : galleryEntityList) {
            galleryDtoList.add(convertEntityToDto(galleryEntity));
        }
        return galleryDtoList;

    }

    private GalleryDto convertEntityToDto (GalleryEntity galleryEntity) {

        return GalleryDto.builder()
            .id(galleryEntity.getId())
            .title(galleryEntity.getTitle())
            .filePath(galleryEntity.getFilePath())
            .imgFullPath("https://" + S3Service.CLOUD_FRONT_DOMAIN_NAME + "/" + galleryEntity.getFilePath())
            .build();

    }




    public void savePost(GalleryDto galleryDto) {
        galleryRepository.save(galleryDto.toEntity());
    }
}
