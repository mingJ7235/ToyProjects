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
    //controller < - > service 통신간에 dto 객체를 사용하기 위해 repository로 부터 얻은 entity 객체를 dto로 변환하는 매서드이다.
    //매개변수로 entity를 받고 (repository를 통해 얻은) return값으로 dto를 반환한다.
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
