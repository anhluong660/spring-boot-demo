package com.royalhek17.hibernate.service;

import com.royalhek17.hibernate.entities.Member;
import com.royalhek17.hibernate.entities.Task;
import com.royalhek17.hibernate.model.MemberDO;
import com.royalhek17.hibernate.model.TaskDO;
import com.royalhek17.hibernate.repository.MemberRepository;
import com.royalhek17.hibernate.repository.TaskRepository;
import com.royalhek17.utils.SampleUtils;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HibernateService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private MemberRepository memberRepository;

    public Task getTaskById(int id) {
        TaskDO taskDO = taskRepository.findById(id).orElse(null);
        if (taskDO == null) {
            return null;
        }

        Task task = new Task();
        BeanUtils.copyProperties(taskDO, task);
        return task;
    }

    @Transactional
    public void saveTask(int memberId, Task task) {
        MemberDO memberDO = memberRepository.findById(memberId).orElse(null);
        if (memberDO == null) {
            return;
        }

        TaskDO taskDO = new TaskDO();
        BeanUtils.copyProperties(task, taskDO);

        taskDO.setMember(memberDO);
        taskRepository.save(taskDO);
    }

    public Member getMemberById(int id) {
        MemberDO memberDO = memberRepository.findById(id).orElse(null);
        if (memberDO == null) {
            return null;
        }

        Member member = new Member();
        BeanUtils.copyProperties(memberDO, member);

        List<Task> tasks = memberDO.getTaskList().stream()
                .map(taskDO -> {
                    Task task = new Task();
                    BeanUtils.copyProperties(taskDO, task);
                    return task;
                })
                .toList();

        member.setTaskList(tasks);
        return member;

    }

    public void saveMember(Member member) {
        MemberDO memberDO = new MemberDO();
        BeanUtils.copyProperties(member, memberDO);
        memberRepository.save(memberDO);
    }
}
