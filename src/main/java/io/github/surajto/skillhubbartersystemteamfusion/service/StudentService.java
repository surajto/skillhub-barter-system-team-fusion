package io.github.surajto.skillhubbartersystemteamfusion.service;

import io.github.surajto.skillhubbartersystemteamfusion.model.Student;

import java.util.List;
import java.util.Optional;


public interface StudentService {
    Student createStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(Long id);

    Student getStudentByName(String name);

    Student getStudentByEmail(String email);
  
    Optional<Student> updateStudentName(long id, String newName);

    Optional<Student> updateStudentEmail(long id, String newEmail);

    Student updateStudentName(Long id, String newName);

    Student updateStudentEmail(Long id, String newEmail);

    Student updateStudentPhone(Long id, Long newPhone);

    Student updateStudentPassword(Long id, String newPassword);

    boolean deleteStudent(long id);
}
