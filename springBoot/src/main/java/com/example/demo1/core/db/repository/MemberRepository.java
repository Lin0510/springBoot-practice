package com.example.demo1.core.db.repository;

import com.example.demo1.core.db.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, String> {
    // 根據角色尋找資料
    List<Member> findByRoleLike(String role);

}
