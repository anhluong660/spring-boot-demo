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
        Assert.assertEquals(memberDO.getId(), member.getId());
        Assert.assertEquals(memberDO.getName(), member.getName());
        Assert.assertEquals(memberDO.getSalary(), member.getSalary());

        for (int i = 0; i < 3; i++) {
            TaskDO taskDO = memberDO.getTaskList().get(i);
            Task task = member.getTaskList().get(i);

            Assert.assertEquals(taskDO.getId(), task.getId());
            Assert.assertEquals(taskDO.getName(), task.getName());
            Assert.assertEquals(taskDO.getTime(), task.getTime());
        }
    }
}
