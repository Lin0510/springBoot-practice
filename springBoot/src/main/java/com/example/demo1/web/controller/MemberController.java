package com.example.demo1.web.controller;

import com.example.demo1.core.db.model.Member;
import com.example.demo1.core.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class MemberController {

    @Autowired
    private IMemberService memberService;

    // 取得所有成員資料(教師、學生)
    @RequestMapping("/all-member")
    public List<Member> getAllMember() {
        List<Member> dataList = memberService.getAllMember();
        return dataList;
    }

    // 取得所有教師資料
    @RequestMapping("/all-teacher")
    public List<Member> teacherList() {
        List<Member> dataList = memberService.getAllTeacher();
        return dataList;
    }

    // 取得所有學生資料
    @RequestMapping("/all-student")
    public List<Member> studentList() {
        List<Member> dataList = memberService.getAllStudent();
        return dataList;
    }

    // 根據輸入的ID取得教師資料
    @RequestMapping("/teacher/findById")
    public Member getTeacher(String id) {
        Member data = memberService.getTeacher(id);
        return data;
    }

    // 根據輸入的ID取得學生資料
    @RequestMapping("/student/findById")
    public Member getStudent(String id) {
        Member data = memberService.getStudent(id);
        return data;
    }

    // 儲存成員資料
    @RequestMapping("/save")
    public String save(Member member) {
        return memberService.save(member);
    }

    // 根據輸入Id刪除成員資料
    @RequestMapping("/delete")
    public String delete(String id) {
        return memberService.delete(id);
    }

    // 更新成員資料
    @RequestMapping("/update")
    public String update(String id, Member member) {
        return memberService.update(id, member);
    }

    // ------------------------------------------------------------------------------------------------------
    // JPA Criteria Queries
    // 取得所有成員資料(教師、學生)
    @RequestMapping("/criteria/all-member")
    public List<Member> getAllMemberByCriteria() {
        List<Member> dataList = memberService.getAllMemberByCriteria();
        return dataList;
    }

    // 取得所有教師資料
    @RequestMapping("/criteria/all-teacher")
    public List<Member> getAllTeacherByCriteria() {
        List<Member> dataList = memberService.getAllTeacherByCriteria();
        return dataList;
    }

    // 取得所有學生資料
    @RequestMapping("/criteria/all-student")
    public List<Member> getAllStudentByCriteria() {
        List<Member> dataList = memberService.getAllStudentByCriteria();
        return dataList;
    }

    // 根據輸入的name取得成員資料
    @RequestMapping("/criteria/findByName")
    public List<Member> findByNameByCriteria(String name) {
        List<Member> dataList = memberService.findByNameByCriteria(name);
        return dataList;
    }

    // 查詢name含有輸入字串的所有成員
    @RequestMapping("/criteria/findByStr")
    public List<Member> findByNameContainsStrByCriteria(String str) {
        List<Member> dataList = memberService.findByNameContainsStrByCriteria(str);
        return dataList;
    }

}
