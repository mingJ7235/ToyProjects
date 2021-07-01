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

    @PostMapping("/api/v1/posts")
    public Long save (@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/vi/posts/{id}")
    public Long update (@PathVariable long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update (id, requestDto);
    }

    @GetMapping("/api/vi/posts/{id}")
    public PostsResponseDto findById (@PathVariable long id) {
        return postsService.findById(id);
    }

}
