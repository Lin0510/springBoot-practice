package com.example.demo1.core.service;

import com.example.demo1.core.db.model.Member;

import java.util.List;

public interface IMemberService {

    // 取得所有成員資料(教師、學生)
    List<Member> getAllMember();

    // 取得所有教師資料
    List<Member> getAllTeacher();

    // 取得所有學生資料
    List<Member> getAllStudent();

    // 根據輸入的ID取得教師資料
    Member getTeacher(String teacherId);

    // 根據輸入的ID取得學生資料
    Member getStudent(String studentId);

    // 儲存成員資料
    String save(Member member);

    // 根據輸入的ID刪除資料
    String delete(String id);

    // 根據輸入的ID更新成員資料(可只更新一個或多個欄位)
    String update(String id, Member member);

    // ---------------------------------------------------------------
    // JPA Criteria Queries

    // 取得所有成員資料(教師、學生)
    List<Member> getAllMemberByCriteria();

    // 根據輸入的name取得成員資料
    List<Member> findByNameByCriteria(String name);

    // 取得所有學生資料
    List<Member> getAllStudentByCriteria();

    // 取得所有教師資料
    List<Member> getAllTeacherByCriteria();

    // 查詢name含有輸入字串的所有成員
    List<Member> findByNameContainsStrByCriteria(String str);

}
