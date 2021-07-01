package com.joshua.springweb.awsspring.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest //H2 DB를 자동으로 실행해준다.
public class PostsRepositoryTest {
    //save, findAll 기능 테스트

    @Autowired
    PostsRepository postsRepository;

    @After //Junit에서 단위 테스트가 끝날 때마다 수행되는 메소드를 지정한다.
    public void cleanup () {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기 () {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";
        String author = "joshua";

        postsRepository.save(Posts.builder() //테이블 posts에 insert/update쿼리를 실행한다.
                                            //id값이 있다면 update가 되고, 없다면 insert가 실행된다. 개쩜...
                .title(title)
                .content(content)
                .author(author)
                .build());

        //when
        List <Posts> postsList = postsRepository.findAll(); //테이블 posts에 있는 모든 데이터를 조회해온다.

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);

    }
}
