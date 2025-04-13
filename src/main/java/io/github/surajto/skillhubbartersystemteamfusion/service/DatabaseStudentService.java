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
    public Optional<Student> updateStudentName(long id, String newName)  {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setStu_name(newName);
            return Optional.of(studentRepository.save(student));
        }
        return null;
    }

    @Override
    public Optional<Student> updateStudentEmail(long id, String newEmail) {
        return Optional.empty();
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
