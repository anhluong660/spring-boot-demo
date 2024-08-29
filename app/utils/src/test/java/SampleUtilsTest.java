import com.royalhek17.utils.SampleUtils;
import entities.Member;
import entities.MemberDO;
import entities.Task;
import entities.TaskDO;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SampleUtilsTest {

    @Test
    public void testCopyProperties() {
        List<TaskDO> taskList = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            TaskDO taskDO = new TaskDO();
            taskDO.setId(i);
            taskDO.setName("task " + i);
            taskDO.setTime(i + 0.5);
            taskList.add(taskDO);
        }

        MemberDO memberDO = new MemberDO();
        memberDO.setId(123);
        memberDO.setName("John");
        memberDO.setSalary(123.45);
        memberDO.setTaskList(taskList);

        Member member = SampleUtils.copyProperties(memberDO, Member.class);

        Assert.assertNotNull(member);
        Assert.assertEquals(Integer.valueOf(123), member.getId());
        Assert.assertEquals("John", member.getName());
        Assert.assertEquals(Double.valueOf(123.45), member.getSalary());

        List<Task> tasks = taskList.stream()
                .map(task -> SampleUtils.copyProperties(task, Task.class))
                .toList();
        member.setTaskList(tasks);

        for (int i = 1; i <= 3; i++) {
            Task task = member.getTaskList().get(i - 1);
            Assert.assertEquals(Integer.valueOf(i), task.getId());
            Assert.assertEquals("task " + i, task.getName());
            Assert.assertEquals(Double.valueOf(i + 0.5), task.getTime());
        }
    }
}
