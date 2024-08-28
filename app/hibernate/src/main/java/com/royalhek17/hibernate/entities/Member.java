package com.royalhek17.hibernate.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Member {

    private Integer id;

    private String name;

    private List<Task> taskList;
}
