package com.royalhek17.hibernate.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Task {
    private Integer id;
    private String name;
    private Integer hours;
}
