package com.joshua.springweb.awsspring.web.dto;

import org.junit.Test;
//import static은 일일이 작성을 해줘야한다. 자동 import가 되지 않는다.
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트 () {
        //단순히 롬복이 작동하는지 테스트하기 위함이다.

        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name); //assertj라는 테스트 검증 라이브러리의 검증 메소드다.
                //검증하고 싶은 대상을 메소드의 인자로 받는다. isEqualTo를 통해 검증한다.
        assertThat(dto.getAmount()).isEqualTo(amount);

        /**
         * junit의 기본 assertThat이 아니라, assertJ의 assertThat을 사용한 이유
         * 1. CoreMatchers와 달리 추가적으로 라이브러리가 필요하지 않다.
         *      -> Junit의 assertThat을 쓰면 is()와 같이 CoreMatcher 라이브러리가 따로 필요하다.
         * 2. 자동완성이 좀 더 확실하게 지원된다.
         */
    }
}
