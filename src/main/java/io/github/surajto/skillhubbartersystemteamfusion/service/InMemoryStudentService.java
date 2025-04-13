package io.github.surajto.skillhubbartersystemteamfusion.service;

import io.github.surajto.skillhubbartersystemteamfusion.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * StudentService class for managing Students operations.
 * This class handles business logic related to Products.
 */
@Service
public class InMemoryStudentService implements StudentService {
     private List<Student> students = new ArrayList<>();

    @Override
    public Student createStudent(Student student) {
        students.add(student);
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        return List.of();
    }

    @Override
    public Student getStudentById(long id) {
        return null;
    }

    @Override
    public Student getStudentByName(String name) {
        return null;
    }

    @Override
    public Student updateStudentName(long id, double newName) {
        return null;
    }

    @Override
    public Student updateStudentEmail(long id, String newEmail) {
        return null;
    }

    @Override
    public Student updateStudentPhone(long id, String newPhone) {
        return null;
    }

    @Override
    public Student updateStudentPassword(long id, String newPassword) {
        return null;
    }

    @Override
    public Student deleteStudent(long id) {
        return null;
    }
}
