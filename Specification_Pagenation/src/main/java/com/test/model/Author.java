package com.test.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Author {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String age;

    @OneToMany (mappedBy = "author")
    private List<Book> bookList;
}
