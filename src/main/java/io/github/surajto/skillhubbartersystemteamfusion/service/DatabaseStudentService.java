package io.github.surajto.skillhubbartersystemteamfusion.service;

import io.github.surajto.skillhubbartersystemteamfusion.model.Student;
import io.github.surajto.skillhubbartersystemteamfusion.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DatabaseStudentService implements StudentService {

    private final StudentRepository studentRepository;

    public DatabaseStudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(Student student) {
        studentRepository.save(student);
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students;
    }

    @Override
    public Student getStudentById(long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.orElse(null);
    }

    @Override
    public Student getStudentByName(String name) {
        Optional<Student> student = studentRepository.findBystu_name(name);
        return student.orElse(null);
    }

    @Override
    public Student getStudentByEmail(String email) {
        Optional<Student> student = studentRepository.findBystu_email(email);
        return student.orElse(null);
    }

    @Override
    public Student updateStudentName(long id, String newName) {
        Student student = getStudentById(id);
        if (student != null) {
            student.setStu_name(newName);
            return studentRepository.save(student);
        }
        return null;
    }

    @Override
    public Student updateStudentEmail(long id, String newEmail) {
        Student student = getStudentById(id);
        if (student != null) {
            student.setStu_email(newEmail);
            return studentRepository.save(student);
        }
        return null;
    }

    @Override
    public Student updateStudentPhone(long id, String newPhone) {
        Student student = getStudentById(id);
        if (student != null) {
            student.setStu_phone(newPhone);
            return studentRepository.save(student);
        }
        return null;
    }

    @Override
    public Student updateStudentPassword(long id, String newPassword) {
        Student student = getStudentById(id);
        if (student != null) {
            student.setStu_password(newPassword);
            return studentRepository.save(student);
        }
        return null;
    }

    @Override
    public boolean deleteStudent(long id) {
        Student student = getStudentById(id);
        if (student != null) {
            studentRepository.delete(student);
            return true;
        }
        return false;
    }
}
