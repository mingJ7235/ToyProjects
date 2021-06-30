package com.joshua.webservice.dto.posts;

import com.joshua.webservice.domain.posts.Posts;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
//Controller에서 @RequestBody로 외부에서 데이터를 받는 경우에는 기본생성자 + set 메소드를 통해서만 값이 할당되므로 setter 허용
@Setter
@NoArgsConstructor
public class PostsSaveRequestDto {

    /**
     * Entity클래스와 거의 유사한 형태임에도 DTO클래스를 추가로 생성함.
     * 그 이유는 테이블과 매핑이되는 Entity 클래스를 Request / Response 클래스로 사용해서는 안되기 때문임
     * Entity 클래스는 가장 Core한 클래스다.
     * 수많은 서비스 클래스와 비지니스 로직이 Entity 클래스를 기준으로 동작한다.
     * DTO는 View를 위한 클래스이므로 Request와 Response용으로 사용된다.
     * View Layer와 DB Layer를 철저하게 역할 분리하는 것이 좋다.
     *
     */

   private String title;
   private String content;
   private String author;

   public Posts toEntity() {
       return Posts.builder()
               .title(title)
               .content(content)
               .author(author)
               .build();
   }
}
