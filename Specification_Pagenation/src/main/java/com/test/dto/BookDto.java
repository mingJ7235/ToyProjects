package com.test.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class BookDto {

    private String title;
    private Long author_id;
    private String price;
    private Date publicshedAt;

}
