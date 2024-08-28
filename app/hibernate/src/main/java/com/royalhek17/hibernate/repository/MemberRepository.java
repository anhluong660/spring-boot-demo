package com.royalhek17.hibernate.repository;

import com.royalhek17.hibernate.model.MemberDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberDO, Integer> {
}
