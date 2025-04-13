package io.github.surajto.skillhubbartersystemteamfusion.service;

import io.github.surajto.skillhubbartersystemteamfusion.model.Student;

import java.util.List;


public interface StudentService {
    Student createStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(long id);

    Student getStudentByName(String name);

    Student updateStudentName(long id, double newName);

    Student updateStudentEmail(long id, String newEmail);

    Student updateStudentPhone(long id, String newPhone);

    Student updateStudentPassword(long id, String newPassword);

    Student deleteStudent(long id);
}
