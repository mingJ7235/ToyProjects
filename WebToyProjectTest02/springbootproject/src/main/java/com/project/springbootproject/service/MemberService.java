package com.project.springbootproject.service;

import com.project.springbootproject.dto.MemberDto;
import com.project.springbootproject.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class MemberService {
    private MemberRepository memberRepository;

    @Transactional
    public Long joinUser (MemberDto memberDto) {
        //비밀번호 암호화
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        memberDto.setPassword

    }
}
