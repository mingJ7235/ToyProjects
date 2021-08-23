package com.joshua.kakao.api.controller;

import com.joshua.kakao.api.service.contract.ProjectKakaoService;
import com.joshua.kakao.api.template.dto.KakaoPageDto;
import com.joshua.kakao.api.template.dto.KakaoTemplateDto;
import com.joshua.kakao.api.template.dto.SearchCriteriaDto;
import com.joshua.kakao.api.template.exception.DuplicateException;
import com.joshua.kakao.api.template.model.KakaoTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import static org.springframework.data.domain.Sort.Direction.DESC;

@RestController
@RequiredArgsConstructor
@RequestMapping ("/kakao/test")
public class KakaoTemplateController {
    private final ProjectKakaoService service;

    @PostMapping ("/templates")
    public KakaoTemplateDto saveTemplate (@ModelAttribute @NotBlank KakaoTemplateDto templateDto) throws DuplicateException {
        return service.saveTemplate(templateDto);
    }

    @PatchMapping ("/templates/{templateCode}")
    public KakaoTemplateDto updateTemplate (@PathVariable @NotBlank String code,
                                @ModelAttribute @Valid KakaoTemplateDto templateDto) throws DuplicateException {
        return service.updateTemplate(code, templateDto);
    }

    @GetMapping ("/templates/{templateCode}")
    public KakaoTemplate getTemplate (@PathVariable @NotBlank Long templateId) {
        return service.getTemplate(templateId);
    }

//    @GetMapping ("/templates")
//    public List<KakaoTemplate> templateList () {
//        return service.getListTemplate();
//    }

    @DeleteMapping ("/templates/{templateId}")
    public int deleteTemplate (@PathVariable @NotBlank String templateCode) {
        return service.deleteTemplate(templateCode);
    }

    @GetMapping ("/templates")
    public KakaoPageDto<KakaoTemplateDto> searchTemplate(
            SearchCriteriaDto criteria,
            @PageableDefault(sort = "id", direction = DESC) Pageable pageable
            ) {
        return service.searchTemplate(criteria, pageable);
    }


}
