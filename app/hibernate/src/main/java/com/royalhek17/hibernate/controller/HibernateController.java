package com.royalhek17.hibernate.controller;

import com.royalhek17.hibernate.entities.Member;
import com.royalhek17.hibernate.entities.Task;
import com.royalhek17.hibernate.service.HibernateService;
import com.royalhek17.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/hibernate")
public class HibernateController {

    @Autowired
    private HibernateService hibernateService;

    @GetMapping("/task/{id}")
    public Response<Task> getTask(@PathVariable Integer id) {
        Task task = hibernateService.getTaskById(id);
        if (task != null) {
            return Response.success(task);
        }

        return Response.error("Not found");
    }

    @PostMapping("/add-task/{memberId}")
    public Response<Task> addNewTask(@PathVariable Integer memberId, @RequestBody Task task) {
        hibernateService.saveTask(memberId, task);
        return Response.success(task);
    }

    @GetMapping("member/{id}")
    public Response<Member> getMember(@PathVariable Integer id) {
        Member member = hibernateService.getMemberById(id);
        if (member != null) {
            return Response.success(member);
        }

        return Response.error("Not found");
    }

    @PostMapping("/add-member")
    public Response<Member> addNewMember(@RequestParam Integer id, @RequestParam String name) {
        Member member = new Member();
        member.setId(id);
        member.setName(name);
        member.setTaskList(new ArrayList<>());

        hibernateService.saveMember(member);
        return Response.success(member);
    }
}
