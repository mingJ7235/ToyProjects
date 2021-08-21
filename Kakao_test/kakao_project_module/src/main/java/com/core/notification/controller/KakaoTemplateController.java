package com.core.notification.controller;

import com.core.template.dto.KakaoTemplateDto;
import com.core.template.exception.DuplicateException;
import com.core.template.model.KakaoTemplate;
import com.core.notification.service.contract.ProjectKakaoService;
import lombok.RequiredArgsConstructor;
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
    public KakaoTemplateDto updateTemplate (@PathVariable @NotBlank String code,
                                @ModelAttribute @Valid KakaoTemplateDto templateDto) throws DuplicateException {
        return service.updateTemplate(code, templateDto);
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
