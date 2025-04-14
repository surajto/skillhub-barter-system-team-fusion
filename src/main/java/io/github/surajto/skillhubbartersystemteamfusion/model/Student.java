package io.github.surajto.skillhubbartersystemteamfusion.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;


/**
 * Represents a Student entity mapped to the "student" table in the database.
 * Includes fields such as ID, name, email, phone, and password.
 */
@Entity
@Table(name = "student")
public class Student {

    /**
     * Unique identifier for the student.
     * This is the primary key and is auto-generated.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long stu_id;

    /**
     * Full name of the student.
     * Must not be blank and should contain 3 to 50 characters.
     */
    @NotBlank( message = "Student name is required")
    @Size(min = 3, max= 50, message = "Student name should be between 3 to 50 characters")
    @Column(nullable = false)
    private String stu_name;

    /**
     * Email address of the student.
     * Must not be blank.
     */
    @NotBlank(message = "Student Email is required")
    @Column(nullable = false)
    private String stu_email;

    /**
     * Phone number of the student.
     * Must not be null and should contain exactly 10 digits.
     */
    @NotNull(message = "Student phone number is required")
    //@Size(min = 10, message ="Student phone number should be of 10 character")
    //@Digits(integer = 10, fraction = 0, message = "Must be 10")
    @Column(nullable = false)
    private Long stu_phone;

    /**
     * Password for student login.
     * Must not be blank and should contain at least 10 characters.
     */
    @NotBlank(message = "Student password is required")
    @Size(min = 10, message = "Password should be atleast 10 characters")
    @Column(nullable = false)
    @JsonIgnore
    private String stu_password;

    /**
     * Default constructor required by JPA.
     */
    public Student() {
    }

    /**
     * Constructs a Student with all required fields except ID.
     *
     * @param stu_name     the student's name
     * @param stu_email    the student's email
     * @param stu_phone    the student's phone number
     * @param stu_password the student's password
     */
    public Student(String stu_name, String stu_email, long stu_phone, String stu_password) {
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

    public long getStu_phone() {return stu_phone;}

    public void setStu_phone(long stu_phone) {this.stu_phone = stu_phone;}

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

    /**
     * Returns a string representation of the student.
     * (Note: It includes password — consider omitting for security)
     *
     * @return string with student details
     */
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
