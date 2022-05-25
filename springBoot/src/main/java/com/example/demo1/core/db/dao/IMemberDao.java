package com.example.demo1.core.db.dao;

import com.example.demo1.core.db.model.Member;

import java.util.List;

public interface IMemberDao {
    // 取得所有成員資料(教師、學生)
    List<Member> getAllMember();

    // 根據輸入的name取得成員資料
    List<Member> findByName(String name);

    // 取得所有教師資料
    List<Member> getAllTeacher();

    // 取得所有學生資料
    List<Member> getAllStudent();

    // 查詢name含有輸入字串的所有成員
    List<Member> findByNameContainsStr(String str);

}
