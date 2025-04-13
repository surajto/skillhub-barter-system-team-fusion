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
        return students;
    }

    @Override
    public Student getStudentById(long id) {
        for(Student student : students) {
            if(student.getStu_id() == id){
                return student;
            }
        }
        return null;
    }

    @Override
    public Student getStudentByName(String name) {
        for(Student student: students){
            if(student.getStu_name().equals(name)){
                return student;
            }
        }
        return null;
    }

    @Override
    public Student getStudentByEmail(String email){
        for(Student student : students){
            if (student.getStu_email().equals(email)){
                return student;
            }
        }
        return null;
    }

    @Override
    public Student updateStudentName(long id, String newName) {
        Student student = getStudentById(id);
        if (student != null) {
            student.setStu_name(newName);
        }
        return null;
    }

    @Override
    public Student updateStudentEmail(long id, String newEmail) {
        Student student = getStudentById(id);
        if (student != null) {
            student.setStu_email(newEmail);
        }
        return null;
    }

    @Override
    public Student updateStudentPhone(long id, String newPhone) {
        Student student = getStudentById(id);
        if(student != null){
            student.setStu_phone(newPhone);
        }
        return null;
    }

    @Override
    public Student updateStudentPassword(long id, String newPassword) {
        Student student = getStudentById(id);
        if (student != null) {
            student.setStu_password(newPassword);
        }
        return null;
    }

    @Override
    public boolean deleteStudent(long id) {
            Student student = getStudentById(id);
            if (student != null) {
                students.remove(student);
            }
        return true;
    }
}
