package com.joshua.springweb.awsspring.domain.posts;

import com.joshua.springweb.awsspring.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor //기본 생성자 자동 추가 (args가 없는 constructor)
@Entity //테이블과 링크가 될 클래스임을 나타낸다. default로 카멜표기법으로 class명이 되어있다면, 테이블네이밍은 _ 언더표기법으로 매칭된다.
public class Posts extends BaseTimeEntity {
    //Posts 클래스는 실제 DB 테이블과 매칭될 클래스이다. 보통 Entity 클래스라고 부른다.
    //JPA를 사용하면 DB 데이터에 작업할 경우 실제 쿼리를 날리기보다 이 Entity 클래스의 수정을 통해 작업한다.

    @Id //해당 테이블, 여기선 Posts의 PK필드를 나타낸다.
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    //PK의 생성 규칙을 나타낸다. springboot 2.0 이상 에서는 GenerationType.IDENTITY 옵션을 추가해야 auto_increment가 된다.
    private Long id;

    @Column (length = 500, nullable = false)
    private String title;

    @Column (columnDefinition = "TEXT", nullable = false) //columnDefinition은 별거없다, 그냥 타입의 변경이다.
    private String content;

    private String author;

    //업데이트를 하기위함 -> update메소드를 통해 정보를 수정한다.
    public void update (String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
    /**
     * 생성자 대신에 @Builder를 통해 제공되는 빌더 클래스를 사용하여 값 변경을 한다.
     * 빌더를 사용하면 어느 필드에 어떤 값을 채워야할지 개발자들이 명확하게 인지할 수 잇다.
     * 그렇기 때문에 명확한 값이 무엇인지 들어갈 수가 있다.
     */
}
