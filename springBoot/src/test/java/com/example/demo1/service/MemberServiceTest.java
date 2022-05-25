package com.example.demo1.service;

import com.example.demo1.core.db.model.Member;
import com.example.demo1.core.service.IMemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class MemberServiceTest {

    @Autowired
    private IMemberService memberService;

    // 取得所有成員資料(教師、學生)
    @Test
    void testGetAllMember() {
        List<Member> list = memberService.getAllMember();
        System.out.println(list);
    }

    // 取得所有教師資料
    @Test
    void testGetAllTeacher() {
        List<Member> list = memberService.getAllTeacher();
        System.out.println(list);
    }

    // 取得所有學生資料
    @Test
    void testGetAllStudent() {
        List<Member> list = memberService.getAllStudent();
        System.out.println(list);
    }

    // 根據輸入的ID取得教師資料
    @Test
    void testGetTeacher() {
        Member member = memberService.getTeacher("10");
        System.out.println(member);
    }

    // 根據輸入的ID取得學生資料
    @Test
    void testGetStudent() {
        Member member = memberService.getStudent("4");
        System.out.println(member);
    }

    // 儲存成員資料
    @Test
    void testSave() {
        Member member = new Member("10","","","",null,null,null,null);
        System.out.print(memberService.save(member));
        System.out.println(memberService.getAllMember());
    }

    // 根據輸入的ID刪除資料
    @Test
    void testDelete() {
        System.out.println(memberService.delete("10"));
    }

    // 根據輸入的ID更新成員資料(可只更新一個或多個欄位)
    @Test
    void testUpdate() {
        Member member = new Member();
        member.setName("Eric");
        System.out.println(memberService.update("7", member));
        System.out.println(memberService.getAllMember());
    }

    // ---------------------------------------------------------------
    // JPA Criteria Queries

    // 取得所有成員資料(教師、學生)
    @Test
    void getAllMemberByCriteria() {
        List<Member> list = memberService.getAllMemberByCriteria();
        System.out.println(list);
    }

    // 根據輸入的name取得成員資料
    @Test
    void testFindByName() {
        String name = "Sally";
        List<Member> list = memberService.findByNameByCriteria(name);
        System.out.println(list);
    }

    // 取得所有學生資料
    @Test
    void testGetAllStudentByCriteria() {
        List<Member> list = memberService.getAllStudentByCriteria();
        System.out.println(list);
    }

    // 取得所有教師資料
    @Test
    void testGetAllTeacherByCriteria() {
        List<Member> list = memberService.getAllTeacherByCriteria();
        System.out.println(list);
    }

    // 查詢name含有輸入字串的所有成員
    @Test
    void findByNameContainsStr() {
        String str = "a";
        List<Member> list = memberService.findByNameContainsStrByCriteria(str);
        System.out.println(list);
    }

}