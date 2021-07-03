package com.joshua.springweb.awsspring.web;

import com.joshua.springweb.awsspring.service.PostsService;
import com.joshua.springweb.awsspring.web.dto.PostsResponseDto;
import com.joshua.springweb.awsspring.web.dto.PostsSaveRequestDto;
import com.joshua.springweb.awsspring.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    //글 등록
    @PostMapping("/api/v1/posts")
    public Long save (@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    //글 수정
    @PutMapping("/api/vi/posts/{id}")
    public Long update (@PathVariable long id, @RequestBody PostsUpdateRequestDto requestDto) {
        System.out.println("requestDto from putmapping (update)"+requestDto);
        return postsService.update (id, requestDto);
    }

    //글 상세 조회
    @GetMapping("/api/vi/posts/{id}")
    public PostsResponseDto findById (@PathVariable long id) {
        return postsService.findById(id);
    }

}
