package com.example.demo.controller;

import com.example.demo.mapper.MemberMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//@Controller
//@Log4j
//@RequestMapping ("/member/*")
//@AllArgsConstructor
@Slf4j
@RestController
public class MemberController {
    @Autowired
    private MemberMapper memberMapper;

    @GetMapping (path = "/helloMapper")
    public String helloMapper () {
        return memberMapper.selectMemberID() + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);

    }
}
