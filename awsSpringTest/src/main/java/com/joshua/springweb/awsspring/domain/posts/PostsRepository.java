package com.joshua.springweb.awsspring.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository <Posts, Long> {
    /**
     * MyBatis등에서 Dao라고 불리는 DB Layer 접근자이다.
     * JPA에서는 Repository라고 부르며, interface로 생성한다.
     */

    //@Query : SpringDataJpa 에서 제공하지 않는 메소드는 이렇게 쿼리로 작성하는 것임!
    //사실, 여기 쿼리는 기본 메소드만으로도 해결될 수 잇으나, 가독성이 좋으니 이렇게 선택하여 사용하면됨
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();

    /**
     * 규모있는 프로젝트에서의 데이터 조회는 Entity클래스만으로 처리하기 위해서 조회용 framework를 추가로 사용한다.
     * 대표적으로 querydsl, jooq, MyBati등이 있다.
     * 조회는 위 3가지 프레임워크중 하나를 통해 조회하고, 등록/수정/삭제 등은 SpringDataJPA를 통해 진행한다.
     *
     * Querydsl이 국내에서는 대세다.
     */
}
