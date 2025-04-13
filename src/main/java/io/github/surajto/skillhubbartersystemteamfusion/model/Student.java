package io.github.surajto.skillhubbartersystemteamfusion.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private long stu_id;

    @Column(nullable = false)
    private String stu_name;

    @Column(nullable = false)
    private String stu_email;

    @Column(nullable = false)
    private String stu_phone;

    @Column(nullable = false)
    private String stu_password;

    public Student() {
    }

    public Student(String stu_name, String stu_email, String stu_phone, String stu_password) {
        this.stu_name = stu_name;
        this.stu_email = stu_email;
        this.stu_phone = stu_phone;
        this.stu_password = stu_password;
    }

    public long getStu_id() {return stu_id;}

    public void setStu_id(long stu_id) {this.stu_id = stu_id;}

    public String getStu_name() {return stu_name;}

    public void setStu_name(String stu_name) {this.stu_name = stu_name;}

    public String getStu_email() {return stu_email;}

    public void setStu_email(String stu_email) {this.stu_email = stu_email;}

    public String getStu_phone() {return stu_phone;}

    public void setStu_phone(String stu_phone) {this.stu_phone = stu_phone;}

    public String getStu_password() {return stu_password;}

    public void setStu_password(String stu_password) {this.stu_password = stu_password;}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return stu_id == student.stu_id && Objects.equals(stu_name, student.stu_name) && Objects.equals(stu_email, student.stu_email) && Objects.equals(stu_phone, student.stu_phone) && Objects.equals(stu_password, student.stu_password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stu_id, stu_name, stu_email, stu_phone, stu_password);
    }

    @Override
    public String toString() {
        return "Student{" +
                "stu_id=" + stu_id +
                ", stu_name='" + stu_name + '\'' +
                ", stu_email='" + stu_email + '\'' +
                ", stu_phone='" + stu_phone + '\'' +
                ", stu_password='" + stu_password + '\'' +
                '}';
    }
}
