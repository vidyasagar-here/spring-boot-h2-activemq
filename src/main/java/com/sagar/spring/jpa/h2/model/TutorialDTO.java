package com.sagar.spring.jpa.h2.model;

import lombok.*;

import java.io.Serializable;

@Data
@Setter
@Getter
@ToString
@NoArgsConstructor
public class TutorialDTO implements Serializable {

    private long id;
    private String title;
    private String description;
    private boolean published;


}
