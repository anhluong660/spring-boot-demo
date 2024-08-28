package entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Task {
    private Integer id;
    private String name;
    private Double time;
}
