package io.github.surajto.skillhubbartersystemteamfusion.service;

import io.github.surajto.skillhubbartersystemteamfusion.Exception.StudentValidationException;
import io.github.surajto.skillhubbartersystemteamfusion.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * StudentService class for managing Students operations.
 * This class handles business logic related to Products.
 */
@Service
public class InMemoryStudentService implements StudentService {

    /** List to simulate a student database in memory. */
     private List<Student> students = new ArrayList<>();

    /**
     * Adds a new student to the in-memory list.
     *
     * @param student the student entity to be added
     * @return the added student
     */
    @Override
    public Student createStudent(Student student) {
        students.add(student);
        return student;
    }

    /**
     * Retrieves all students stored in memory.
            *
            * @return list of all students
     */
    @Override
    public List<Student> getAllStudents() {
        return students;
    }

    /**
     * Finds a student by their ID.
     *
     * @param id the ID of the student
     * @return the student with the given ID, or null if not found
     */
    @Override
    public Student getStudentById(Long id) {
        for(Student student : students) {
            if(student.getStu_id() == id){
                return student;
            }
        }
        return null;
    }

    /**
     * Finds a student by their name.
     *
     * @param name the name of the student
     * @return the student with the given name, or null if not found
     */
    @Override
    public Student getStudentByName(String name) {
        for(Student student: students){
            if(student.getStu_name().equals(name)){
                return student;
            }
        }
        return null;
    }

    /**
     * Finds a student by their email.
     *
     * @param email the email of the student
     * @return the student with the given email, or null if not found
     */
    @Override
    public Student getStudentByEmail(String email){
        for(Student student : students){
            if (student.getStu_email().equals(email)){
                return student;
            }
        }
        return null;
    }

    /**
     * Updates the name of a student.
     *
     * @param id the ID of the student
     * @param newName the new name to be set
     * @return the updated student, or null if student not found
     */
    @Override
    public Student updateStudentName(Long id, String newName) {
        Student student = getStudentById(id);
        if (student != null) {
            student.setStu_name(newName);
        }
        return null;
    }
    }

    /**
     * Updates the email of a student.
     *
     * @param id the ID of the student
     * @param newEmail the new email to be set
     * @return the updated student, or null if student not found
     */
    @Override
    public Student updateStudentEmail(Long id, String newEmail) {
        Student student = getStudentById(id);
        if (student != null) {
            student.setStu_email(newEmail);
        }
        return null;
    }

    /**
     * Updates the phone number of a student.
     *
     * @param id the ID of the student
     * @param newPhone the new phone number to be set
     * @return the updated student, or null if student not found
     */
    @Override
    public Student updateStudentPhone(Long id, Long newPhone) {
        Student student = getStudentById(id);
        if(student != null){
            student.setStu_phone(newPhone);
        }
        return null;
    }

    /**
     * Updates the password of a student.
     *
     * @param id the ID of the student
     * @param newPassword the new password to be set
     * @return the updated student, or null if student not found
     */
    @Override
    public Student updateStudentPassword(Long id, String newPassword) {
        Student student = getStudentById(id);
        if (student != null) {
            student.setStu_password(newPassword);
        }
        return null;
    }

    /**
            * Deletes a student by their ID.
            *
            * @param id the ID of the student to be deleted
     * @return true (Note: this implementation always returns true and does not actually remove the student)
            */
    @Override
    public boolean deleteStudent(long id) {
        return true;
    }
}
