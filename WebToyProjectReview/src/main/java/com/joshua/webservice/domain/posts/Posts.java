package com.joshua.webservice.domain.posts;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//실제 DB의 테이블과 매칭될 클래스이며 보통 Entity클래스라고 한다.
@NoArgsConstructor (access = AccessLevel.PROTECTED)
    //Entity 클래스를 프로젝트 코드상에서 기본생성자로 생성하는 것은 막되, JPA에서 Entity클래스를 생성하는 것은 허용하기 위해 추가.

@Getter
@Entity // 테이블과 링크될 클래스임을 나타낸다. 언더스코어 네이밍으로 (_) 이름이 매칭된다.
public class Posts {

    @Id //pk필드
    @GeneratedValue //pk의 생성규칙.
    //보통 Entity의 PK는 Long 타입의 Auto_increment를 사용한다.
    private Long id;

    @Column (length = 500, nullable = false)
    //테이블의 컬럼을 나타내면, 굳이 @column을 선언하지 않더라도 해당 클래스의 필드는 모두 컬럼이된다.
    //@Column을 사용하는 이유는, 기본값 외에 추가로 변경이 필요한 옵션이 있을 경우 사용한다.
    private String title;

    @Column (columnDefinition = "TEXT", nullable = false)
    private String content;

    //@Column 어노테이션이 없지만 기본적으로 default option으로 필드가 컬럼이 된다.
    private String author;

    //해당 클래스의 빌더 패턴 클래스를 생성
    // 생성자 상단에 선언시 생성자에 포하묀 필드만 빌드에 포함한다.
    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    //Entity 클래스 생성시 주의해야할 것은 무분별한 setter 매소드 생성이다.
}
