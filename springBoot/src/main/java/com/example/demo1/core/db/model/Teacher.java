package com.example.demo1.core.db.model;

import lombok.Data;

@Data
public class Teacher extends Member {

    private String subject;
    private String jobTitle;

    public Teacher(String id, String name, String gender, String role, String subject, String jobTitle) {
        super(id, name, gender, role);
        this.subject = subject;
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + super.getId() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", gender='" + super.getGender() + '\'' +
                ", role='" + super.getRole() + '\'' +
                ", subject='" + this.subject + '\'' +
                ", jobTitle='" + this.jobTitle + '\'' +
                '}' + "\n";
    }

}
