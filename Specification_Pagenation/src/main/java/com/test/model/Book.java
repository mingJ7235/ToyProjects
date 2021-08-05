package com.test.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Book {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn (name = "author_id")
    private Author author;

    @Column (nullable = false)
    private String price;
    private Date publishedAt;

}
