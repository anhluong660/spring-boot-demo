package com.royalhek17.hibernate.repository;

import com.royalhek17.hibernate.model.TaskDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskDO, Integer> {
}
