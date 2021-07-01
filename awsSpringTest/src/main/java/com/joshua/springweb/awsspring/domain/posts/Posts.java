package com.joshua.springweb.awsspring.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity //테이블과 링크가 될 클래스임을 나타낸다. 카멜표기법으로 class명이 되어있다면, 테이블네이밍은 _ 언더표기법으로 매칭된다.
public class Posts {
    //Posts 클래스는 실제 DB 테이블과 매칭될 클래스이다. 보통 Entity 클래스라고 부른다.
    //JPA를 사용하면 DB 데이터에 작업할 경우 실제 쿼리를 날리기보다 이 Entity 클래스의 수정을 통해 작업한다.

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (length = 500, nullable = false)
    private String title;

    @Column (columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
