package com.example.demo1.core.db.model;

import lombok.Data;

@Data
public class Student extends Member {

    private String admissionYearMonth;
    private String classes;

    public Student(String id, String name, String gender, String role, String admissionYearMonth, String classes) {
        super(id, name, gender, role);
        this.admissionYearMonth = admissionYearMonth;
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + super.getId() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", gender='" + super.getGender() + '\'' +
                ", role='" + super.getRole() + '\'' +
                ", admissionYearMonth='" + this.admissionYearMonth + '\'' +
                ", classes='" + this.classes + '\'' +
                '}' + "\n";
    }

}
