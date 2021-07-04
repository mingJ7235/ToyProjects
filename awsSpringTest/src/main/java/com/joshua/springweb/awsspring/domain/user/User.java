package com.joshua.springweb.awsspring.domain.user;

import com.joshua.springweb.awsspring.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING) // JPA로 DB로 지정할때 ENUM 값을 어떤 형태로 저장할지를 결정한다.
                    //기본 디폴트는int로 돈 숫자가 저장이되는데
                    //숫자로 지정이 되면 DB로 확인할 때 그 값이 무슨 코드를 의미하는지 알수가 없다.
                    //그래서 문자열로 저장될 수 있도록 EnumType.STRING으로 선언하는 것이다.
    @Column(nullable = false)
    private Role role;

    @Builder
    public User(String name, String email, String picture, Role role) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }

    public User update (String name, String picture) {
        this.name = name;
        this.picture = picture;

        return this;
    }

    public String getRoleKey () {
        return this.role.getKey();
    }
}
