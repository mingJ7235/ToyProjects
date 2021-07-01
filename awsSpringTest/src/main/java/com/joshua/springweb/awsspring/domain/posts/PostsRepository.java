package com.joshua.springweb.awsspring.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository <Posts, Long> {
    /**
     * MyBatis등에서 Dao라고 불리는 DB Layer 접근자이다.
     * JPA에서는 Repository라고 부르며, interface로 생성한다.
     */
}
