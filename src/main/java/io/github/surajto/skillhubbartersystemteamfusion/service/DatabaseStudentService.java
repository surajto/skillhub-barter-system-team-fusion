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

    /** Repository for performing CRUD operations on Student entities. */
    private final StudentRepository studentRepository;

    /** Self-injected service instance, useful for AOP or proxy-based operations. */
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

    /**
     * Creates a new student record in the database.
     *
     * @param student the student entity to be created
     * @return the created student
     * @throws StudentValidationException if the student is null
     */
    @Override
    public Student createStudent(Student student) {
        if (student == null) {
            throw new StudentValidationException("Student must not be null");
        }
        return studentRepository.save(student);
    }

    /**
     * Retrieves all students from the database.
     *
     * @return list of all students
     * @throws StudentNotFoundException if no students are found
     */
    @Override
    public List<Student> getAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        if (studentList.isEmpty()) {
            throw new StudentNotFoundException("No student found");
        }
        return studentList;
    }

    /**
     * Retrieves a student by their ID.
     *
     * @param id the ID of the student
     * @return the student with the specified ID
     * @throws StudentNotFoundException if the student is not found
     */
    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with id " + id + " not found"));
    }

    /**
     * Retrieves a student by their name.
     *
     * @param name the name of the student
     * @return the student with the specified name
     * @throws StudentNotFoundException if the student is not found
     */
    @Override
    public Student getStudentByName(String name) {
        return studentRepository.findBystu_name(name)
                .orElseThrow(() -> new StudentNotFoundException("Student with name " + name + " not found"));
    }

    /**
     * Retrieves a student by their email.
     *
     * @param email the email of the student
     * @return the student with the specified email
     * @throws StudentNotFoundException if the student is not found
     */
    @Override
    public Student getStudentByEmail(String email) {
        return studentRepository.findBystu_email(email)
                .orElseThrow(() -> new StudentNotFoundException("Student with id " + email + " not found"));
    }

    /**
     * Updates the name of a student.
     *
     * @param id the ID of the student
     * @param newName the new name to be set
     * @return the updated student
     * @throws StudentNotFoundException if the student is not found
     * @throws StudentValidationException if the new name is null or empty
     */
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

    /**
     * Updates the email of a student.
     *
     * @param id the ID of the student
     * @param newEmail the new email to be set
     * @return the updated student
     * @throws StudentNotFoundException if the student is not found
     * @throws StudentValidationException if the new email is null or empty
     */
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

    /**
     * Updates the phone number of a student.
     *
     * @param id the ID of the student
     * @param newPhone the new phone number to be set
     * @return the updated student
     * @throws StudentNotFoundException if the student is not found
     */
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

    /**
     * Updates the password of a student.
     *
     * @param id the ID of the student
     * @param newPassword the new password to be set
     * @return the updated student
     * @throws StudentNotFoundException if the student is not found
     * @throws StudentValidationException if the new password is null or empty
     */
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

    /**
     * Deletes a student by their ID.
     *
     * @param id the ID of the student to be deleted
     * @return true if the deletion was successful
     * @throws StudentNotFoundException if the student does not exist
     */
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
