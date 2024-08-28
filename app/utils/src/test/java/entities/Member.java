package entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Member {
    private Integer id;
    private String name;
    private Double salary;
    private List<Task> taskList;
}
