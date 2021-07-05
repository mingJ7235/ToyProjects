package com.joshua.springweb.awsspring.web;

import com.joshua.springweb.awsspring.config.auth.LoginUser;
import com.joshua.springweb.awsspring.config.auth.dto.SessionUser;
import com.joshua.springweb.awsspring.domain.user.User;
import com.joshua.springweb.awsspring.service.PostsService;
import com.joshua.springweb.awsspring.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller

/**
 * IndexController는 GetMapping 즉, 화면 전환에 대한 컨트롤러를 달아 놓았다.
 * API와 Presentation Tier에 대한 분리를 해놓는것이 좋아 보인다.
 * Dto를 통해 Model객체에 데이터를 전달하거나,
 * Service를 통해 Model객체에 담아 정보를 Presentation Tier에 담아준다.
 */
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    //머스테치 스타터 덕분에 컨트롤러에서 문자열을 반환할 시, 앞에 경로와 뒤의 파일 확장자는 자동으로 지정된다.
    //앞의 경로 : src/main/resources/templates
    //뒤의 파일 확장자 : .mustache
    // 최종 반환 값 -> src/main/resources/templates/index.mustache -> View resolver가 처리한다.
    @GetMapping("/")
                            //이제는 어느 컨트롤러든지 @LoginUser만 사용하면 세션정보를 가져올 수 있게 된다.
    public String index (Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());
        model.addAttribute("nums", postsService.totalNum());

        //Session값이 null 이아니라면 userName을 사용할 수 있게 model에 담아서 보낸다.
        //그러나 이부분은 index말고도 다른 부분에서도 반복되어서 사용되어질수 있다.
        //그래서 이 부분을 메소드 인자로 세션값을 바로 받을 수 있도록 변경해야한다.
        //SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if(user != null) {
            model.addAttribute("userName", user.getName());
        }

        return "index";
    }

    //글 등록 페이지 전환
    @GetMapping("/posts/save")
    public String postsSave () {
        return "posts-save";
    }

    //글 상세보기 페이지 전환
    @GetMapping("/posts/detail/{id}")
    public String postsDetail (@PathVariable Long id,  Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-detail";
    }

    //글 수정 페이지 전환
    @GetMapping("/posts/update/{id}")
    public String postsUpdate (@PathVariable long id, Model model) {

        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }

}
