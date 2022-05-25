package com.example.demo1.core.db.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "member")
public class Member {

    @Id
    private String id;
    private String name;
    private String gender;
    private String role;
    private String subject;
    private String jobTitle;
    private String admissionYearMonth;
    private String classes;

    public Member() {
    }

    public Member(String id, String name, String gender, String role) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.role = role;
    }

    public Member(String id, String name, String gender, String role, String subject, String jobTitle, String admissionYearMonth, String classes) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.role = role;
        this.subject = subject;
        this.jobTitle = jobTitle;
        this.admissionYearMonth = admissionYearMonth;
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", role='" + role + '\'' +
                ", subject='" + subject + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", admissionYearMonth='" + admissionYearMonth + '\'' +
                ", classes='" + classes + '\'' +
                '}' + "\n";
    }

}
