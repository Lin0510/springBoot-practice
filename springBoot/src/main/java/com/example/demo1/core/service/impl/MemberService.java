package com.example.demo1.core.service.impl;

import com.example.demo1.core.db.dao.IMemberDao;
import com.example.demo1.core.db.model.Member;
import com.example.demo1.core.db.model.Student;
import com.example.demo1.core.db.model.Teacher;
import com.example.demo1.core.db.repository.MemberRepository;
import com.example.demo1.web.handler.MyException;
import com.example.demo1.core.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MemberService implements IMemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private IMemberDao memberDao;

    // 取得所有成員資料(教師、學生)
    @Override
    public List<Member> getAllMember() {
        List<Member> memberList = memberRepository.findAll();

        if (memberList.isEmpty()) {
            throw new MyException("無成員資料");
        }

        List<Member> dataList = memberList.stream()
                .map(result -> {
                    String id = result.getId();
                    String name = result.getName();
                    String gender = result.getGender();
                    String role = result.getRole();

                    if (result.getRole().equals("teacher")) {
                        String subject = result.getSubject();
                        String jobTitle = result.getJobTitle();

                        Teacher data = new Teacher(id, name, gender, role, subject, jobTitle);

                        return data;
                    } else {
                        String admissionYearMonth = result.getAdmissionYearMonth();
                        String classes = result.getClasses();

                        Student data = new Student(id, name, gender, role, admissionYearMonth, classes);

                        return data;
                    }
                }).collect(Collectors.toList());

        return dataList;
    }


    // 取得所有教師資料
    @Override
    public List<Member> getAllTeacher() {
        List<Member> memberList = memberRepository.findByRoleLike("teacher");

        if (memberList.isEmpty()) {
            throw new MyException("沒有成員資料");
        } else {
            List<Member> dataList = memberList.stream()
                    .map(result -> {
                        String id = result.getId();
                        String name = result.getName();
                        String gender = result.getGender();
                        String role = result.getRole();
                        String subject = result.getSubject();
                        String jobTitle = result.getJobTitle();

                        Teacher teacher = new Teacher(id, name, gender, role, subject, jobTitle);

                        return teacher;
                    }).collect(Collectors.toList());

            return dataList;
        }
    }

    // 取得所有學生資料
    @Override
    public List<Member> getAllStudent() {
        List<Member> memberList = memberRepository.findByRoleLike("student");

        if (memberList.isEmpty()) {
            throw new MyException("找不到成員資料");
        } else {
            List<Member> dataList = memberList.stream()
                    .map(result -> {
                        String id = result.getId();
                        String name = result.getName();
                        String gender = result.getGender();
                        String role = result.getRole();
                        String admissionYearMonth = result.getAdmissionYearMonth();
                        String classes = result.getClasses();

                        Student student = new Student(id, name, gender, role, admissionYearMonth, classes);

                        return student;
                    }).collect(Collectors.toList());

            return dataList;
        }
    }

    // 根據輸入的ID取得教師資料
    @Override
    public Member getTeacher(String teacherId) {
        Optional<Member> resultOption = memberRepository.findById(teacherId);

        if (resultOption.isPresent()) {
            Member member = resultOption.get();

            if (member.getRole().equals("teacher")) {
                String id = member.getId();
                String name = member.getName();
                String gender = member.getGender();
                String role = member.getRole();
                String subject = member.getSubject();
                String jobTitle = member.getJobTitle();

                Teacher teacher = new Teacher(id, name, gender, role, subject, jobTitle);

                return teacher;
            }
            throw new MyException("查無此位老師");
        }
        throw new MyException("查無此位老師");
    }

    // 根據輸入的ID取得學生資料
    @Override
    public Member getStudent(String studentId) {
        Optional<Member> resultOption = memberRepository.findById(studentId);

        if (resultOption.isPresent()) {
            Member member = resultOption.get();

            if (member.getRole().equals("student")) {
                String id = member.getId();
                String name = member.getName();
                String gender = member.getGender();
                String role = member.getRole();
                String admissionYearMonth = member.getAdmissionYearMonth();
                String classes = member.getClasses();

                Student data = new Student(id, name, gender, role, admissionYearMonth, classes);

                return data;
            }
            throw new MyException("查無此位學生");
        }
        throw new MyException("查無此位學生");
    }

    // 儲存成員資料
    @Override
    public String save(Member member) {
        if (member.getId() == null || member.getId().equals("") ||
                member.getName() == null || member.getName().equals("") ||
                member.getGender() == null || member.getGender().equals("") ||
                member.getRole() == null || member.getRole().equals("")) {

            throw new MyException("id、姓名、性別、角色任一欄位不能為空值");
        }
        memberRepository.save(member);

        return member.getName() + "的資料儲存成功!";
    }

    // 根據輸入的ID刪除資料
    @Override
    public String delete(String id) {
        Optional<Member> member = memberRepository.findById(id);
        if (member.isPresent()) {
            memberRepository.deleteById(id);

            return "成功刪除:" + member.get().getName() + "的資料";
        } else {
            throw new MyException("無此id的成員資料!!!");
        }
    }

    // 根據輸入的ID更新成員資料(可只更新一個或多個欄位)
    @Override
    public String update(String id, Member member) {
        Optional<Member> resultOption = memberRepository.findById(id);

        if (resultOption.isPresent()) {
            Member data = resultOption.get();

            String name = member.getName() == null ? data.getName() : member.getName();
            String gender = member.getGender() == null ? data.getGender() : member.getGender();
            String role = member.getRole() == null ? data.getRole() : member.getRole();
            String subject = member.getSubject() == null ? data.getSubject() : member.getSubject();
            String jobTitle = member.getJobTitle() == null ? data.getJobTitle() : member.getJobTitle();
            String admissionYearMonth = member.getAdmissionYearMonth() == null ? data.getAdmissionYearMonth() : member.getAdmissionYearMonth();
            String classes = member.getClasses() == null ? data.getClasses() : member.getClasses();

            Member result = new Member(id, name, gender, role, subject, jobTitle, admissionYearMonth, classes);
            memberRepository.save(result);

            return name + "的資料成功更新";
        }
        memberRepository.save(member);

        return member.getName() + "的資料成功更新";
    }

    // ------------------------------------------------------------------------------------------------------
    // JPA Criteria Queries

    //取得所有成員資料
    @Override
    public List<Member> getAllMemberByCriteria() {
        List<Member> dataList = memberDao.getAllMember();
        return dataList;
    }

    // 取得所有教師資料
    @Override
    public List<Member> getAllTeacherByCriteria() {
        List<Member> dataList = memberDao.getAllTeacher();
        return dataList;
    }

    // 取得所有學生資料
    @Override
    public List<Member> getAllStudentByCriteria() {
        List<Member> dataList = memberDao.getAllStudent();
        return dataList;
    }

    @Override
    // 根據輸入的name取得成員資料
    public List<Member> findByNameByCriteria(String name) {
        List<Member> dataList = memberDao.findByName(name);

        if (dataList.isEmpty()) {
            throw new MyException("查無此名字成員");
        } else {
            return dataList;
        }
    }

    // 查詢name含有輸入字串的所有成員
    @Override
    public List<Member> findByNameContainsStrByCriteria(String str) {
        List<Member> dataList = memberDao.findByNameContainsStr(str);

        if (str.equals("")) {
            throw new MyException("請輸入查詢字段");
        } else {
            if (dataList.isEmpty()) {
                throw new MyException("查無名字含有此字段成員");
            } else {
                return dataList;
            }
        }
    }

}

