package com.project.springbootproject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {
    Long id;
    String email;
    String password;
    LocalDateTime createdDate;
    LocalDateTime modifiedDate;
}
