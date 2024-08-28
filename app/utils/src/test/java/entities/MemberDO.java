package entities;

import lombok.Data;

import java.util.List;

@Data
public class MemberDO {
    private Integer id;
    private String name;
    private Double salary;
    private List<TaskDO> taskList;
}
