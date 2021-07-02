package com.joshua.springweb.awsspring.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    //머스테치 스타터 덕분에 컨트롤러에서 문자열을 반환할 시, 앞에 경로와 뒤의 파일 확장자는 자동으로 지정된다.
    //앞의 경로 : src/main/resources/templates
    //뒤의 파일 확장자 : .mustache
    // 최종 반환 값 -> src/main/resources/templates/index.mustache -> View resolver가 처리한다.
    @GetMapping("/")
    public String index () {
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave () {
        return "posts-save";
    }
}
