package io.github.surajto.skillhubbartersystemteamfusion.service;

import io.github.surajto.skillhubbartersystemteamfusion.Exception.StudentNotFoundException;
import io.github.surajto.skillhubbartersystemteamfusion.Exception.StudentValidationException;
import io.github.surajto.skillhubbartersystemteamfusion.model.Student;
import io.github.surajto.skillhubbartersystemteamfusion.repository.StudentRepository;
import jakarta.validation.constraints.Email;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service implementation for managing Student entities.
 * Handles business logic for CRUD operations and delegates database interaction to the repository.
 */
@Service
public class DatabaseStudentService implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentService studentService;

    /**
     * Constructs a DatabaseStudentService with required dependencies.
     *
     * @param studentService     self-injected service (useful for AOP/proxying)
     * @param studentRepository  repository for accessing the student database
     */
    public DatabaseStudentService(@Qualifier("databaseStudentService") @Lazy StudentService studentService, StudentRepository studentRepository) {
        this.studentService = studentService;
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(Student student) {
        if (student == null) {
            throw new StudentValidationException("Student must not be null");
        }
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        if (studentList.isEmpty()) {
            throw new StudentNotFoundException("No student found");
        }
        return studentList;
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with id " + id + " not found"));
    }

    @Override
    public Student getStudentByName(String name) {
        return studentRepository.findBystu_name(name)
                .orElseThrow(() -> new StudentNotFoundException("Student with name " + name + " not found"));
    }

    @Override
    public Student getStudentByEmail(String email) {
        return studentRepository.findBystu_email(email)
                .orElseThrow(() -> new StudentNotFoundException("Student with id " + email + " not found"));
    }

    @Override
    public Student updateStudentName(Long id, String newName) {
        Optional<Student> student = studentRepository.getStudentsByStu_id(id);
        if (student.isEmpty()) {
            throw new StudentNotFoundException("Student with id " + id + " not found");
        }
        if(newName.isEmpty()||newName == null){
            throw new StudentValidationException("Student name must not be null or empty");
        }
        student.get().setStu_name(newName);
        studentRepository.save(student.get());
        return student.get();
    }

    @Override
    public Student updateStudentEmail(Long id, @Email String newEmail) {
        Optional<Student> student = studentRepository.getStudentsByStu_id(id);
        if (student.isEmpty()) {
            throw new StudentNotFoundException("Student with id " + id + " not found");
        }
        if(newEmail.isEmpty()||newEmail == null){
            throw new StudentValidationException("Student name must not be null or empty");
        }
        student.get().setStu_email(newEmail);
        studentRepository.save(student.get());
        return student.get();
    }

    @Override
    public Student updateStudentPhone(Long id, Long newPhone) {
        Optional<Student> student = studentRepository.getStudentsByStu_id(id);
        if (student.isEmpty()) {
            throw new StudentNotFoundException("Student with id " + id + " not found");
        }
        student.get().setStu_phone(newPhone);
        studentRepository.save(student.get());
        return student.get();
    }

    @Override
    public Student updateStudentPassword(Long id, String newPassword) {
        Optional<Student> student = studentRepository.getStudentsByStu_id(id);
        if (student.isEmpty()) {
            throw new StudentNotFoundException("Student with id " + id + " not found");
        }
        if(newPassword.isEmpty()||newPassword == null){
            throw new StudentValidationException("Password cannot be null or empty");
        }
        student.get().setStu_password(newPassword);
        studentRepository.save(student.get());
        return student.get();
    }

    @Override
    public boolean deleteStudent(long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        } else {
            throw new StudentNotFoundException("Student with id " + id + " not found");
        }
    }
}
