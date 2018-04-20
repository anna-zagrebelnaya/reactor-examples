package com.anka.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class User {

    @Id
    private String id;

    @NotNull
    private String name;
    @NotNull
    private Role role;
    private List<Article> articles;

}