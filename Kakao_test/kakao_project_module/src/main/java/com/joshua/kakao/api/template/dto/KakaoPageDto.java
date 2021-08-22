package com.joshua.kakao.api.template.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class KakaoPageDto <T> {

    private List<T> content;
    private int page;
    private int size;

    public KakaoPageDto (Page<T> page) {
        this.content = page.getContent();
        this.page = page.getPageable().getPageNumber();
        this.size = page.getSize();
    }
}
