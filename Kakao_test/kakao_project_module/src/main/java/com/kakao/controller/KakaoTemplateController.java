package com.kakao.controller;

import com.kakao.dto.KakaoTemplateDto;
import com.kakao.model.KakaoTemplate;
import com.kakao.service.contract.ProjectKakaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping ("/kakao/test")
public class KakaoTemplateController {
    private final ProjectKakaoService service;

    @PostMapping ("/templates")
    public Long saveTemplate (@ModelAttribute @Valid KakaoTemplateDto templateDto) {
        return service.saveTemplate(templateDto);
    }

    @PatchMapping ("/templates/{templateId}")
    public Long updateTemplate (@PathVariable @NotBlank Long templateId,
                                @ModelAttribute @Valid KakaoTemplateDto templateDto) {
        return service.updateTemplate(templateId, templateDto);
    }

    @GetMapping ("/templates/{templateId}")
    public KakaoTemplate getTemplate (@PathVariable @NotBlank Long templateId) {
        return service.getTemplate(templateId);
    }

    @GetMapping ("/templates")
    public List<KakaoTemplate> templateList () {
        return service.getListTemplate();
    }

    @DeleteMapping ("/templates/{templateId}")
    public void deleteTemplate (@PathVariable @NotBlank Long templateId) {
        service.deleteTemplate(templateId);
    }

}
