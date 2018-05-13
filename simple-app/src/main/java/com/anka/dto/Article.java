package com.anka.dto;

import org.springframework.data.annotation.Id;

public class Article {

    @Id
    private String id;

    private String subject;
    private String text;

}