package com.royalhek17.hibernate.service;

import com.royalhek17.hibernate.entities.Member;
import com.royalhek17.hibernate.entities.Task;
import com.royalhek17.hibernate.model.MemberDO;
import com.royalhek17.hibernate.model.TaskDO;
import com.royalhek17.hibernate.repository.MemberRepository;
import com.royalhek17.hibernate.repository.TaskRepository;
import com.royalhek17.utils.SampleUtils;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        return SampleUtils.copyProperties(taskDO, Task.class);
    }

    @Transactional
    public void saveTask(int memberId, Task task) {
        MemberDO memberDO = memberRepository.findById(memberId).orElse(null);
        if (memberDO == null) {
            return;
        }

        TaskDO taskDO = SampleUtils.copyProperties(task, TaskDO.class);
        if (taskDO != null) {
            taskDO.setMember(memberDO);
            taskRepository.save(taskDO);
        }
    }

    public Member getMemberById(int id) {
        MemberDO memberDO = memberRepository.findById(id).orElse(null);
        if (memberDO == null) {
            return null;
        }

        return SampleUtils.deepCopyProperties(memberDO, Member.class);
    }

    public void saveMember(Member member) {
        MemberDO memberDO = SampleUtils.copyProperties(member, MemberDO.class);
        if (memberDO != null) {
            memberRepository.save(memberDO);
        }
    }
}
