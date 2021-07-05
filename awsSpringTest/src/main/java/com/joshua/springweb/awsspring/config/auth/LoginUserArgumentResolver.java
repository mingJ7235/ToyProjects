package com.joshua.springweb.awsspring.config.auth;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

//HandlerMethodArgumentResolver를 구현한 클래스.
/**
 * HandlerMethodArgumentResolver는 한가지 기능을 지원한다. 조건에 맞는 경우 메소드가 있다면 HandlerMethodArgumentResolver의
 * 구현체가 지정한 값으로 해당 메소드의 파라미터로 넘길 수 있다.
 */


public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        return null;
    }
}
