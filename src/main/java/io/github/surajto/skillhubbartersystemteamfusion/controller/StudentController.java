package io.github.surajto.skillhubbartersystemteamfusion.controller;

import io.github.surajto.skillhubbartersystemteamfusion.model.Student;
import io.github.surajto.skillhubbartersystemteamfusion.service.InMemoryStudentService;
import io.github.surajto.skillhubbartersystemteamfusion.service.StudentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for handling student-related API operations.
 * All endpoints are prefixed with "/api/stu".
 */
@RestController
@RequestMapping("/api/stu")
@Validated
public class StudentController {
    private final StudentService studentService;

    /**
     * Constructor-based dependency injection for StudentService.
     *
     * @param studentService the service implementation to be used (qualified by "databaseStudentService")
     */
    @Autowired
    public StudentController(@Qualifier("databaseStudentService") StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * Endpoint to create a new student.
     *
     * @param student the student object to be created (validated and size-checked)
     * @return ResponseEntity containing the created student and HTTP status 201
     */
    @PostMapping
    public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student){
        Student savedStudent = studentService.createStudent(student);
        return new ResponseEntity<>(savedStudent,HttpStatus.CREATED);
    }

    /**
     * Retrieves all students.
     *
     * @return ResponseEntity containing list of all students
     */
    @GetMapping

    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    /**
     * Retrieves a student by ID.
     *
     * @param id the ID of the student
     * @return ResponseEntity with the student if found, or 404 if not found
     */
    @GetMapping("/{id}")

    public ResponseEntity<Student> getStudentById(@PathVariable long id){
        Student student = studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }
  
    /**
     * Retrieves a student by name.
     *
     * @param name the name of the student
     * @return the student object if found
     */
  
    @GetMapping("/name/{name}")
    public Student getStudentByName(@PathVariable String name) {
        return studentService.getStudentByName(name);
    }

    /**
     * Retrieves a student by email.
     *
     * @param email the email of the student
     * @return ResponseEntity with the student if found
     */
    @GetMapping("/email/{email}")
    public ResponseEntity<Student> getStudentByEmail(@PathVariable String email){
        Student student = studentService.getStudentByEmail(email);
        return ResponseEntity.ok(student);
    }

    /**
     * Updates a student's name.
     *
     * @param id      the student ID
     * @param newName the new name (sent in request body)
     * @return ResponseEntity with the updated student or 404 if not found
     */
    @PutMapping("/updateName/{id}")
    public ResponseEntity<Student> updateStudentName(@PathVariable @Positive Long id, @RequestBody String newName){
        newName = newName.replaceAll("[\"{}\\r\\n]", "").replace("stu_name:", "").trim();
        Student student = studentService.updateStudentName(id, newName);
        if(student != null){
            return ResponseEntity.ok(student);
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Updates a student's phone number.
     *
     * @param id       the student ID
     * @param newPhone the new phone number
     * @return ResponseEntity with the updated student or 404 if not found
     */
    @PutMapping("/updatePhone/{id}/{newPhone}")
    public ResponseEntity<Student> updateStudentPhone(@PathVariable @Positive Long id, @PathVariable Long newPhone) {
        Student student = studentService.updateStudentPhone(id, newPhone);
        if (student != null) {
            return ResponseEntity.ok(student);
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Updates a student's email.
     *
     * @param id       the student ID
     * @param newEmail the new email (sent in request body)
     * @return ResponseEntity with the updated student or 404 if not found
     */
    @PutMapping("/updateEmail/{id}")
    public ResponseEntity<Student> updateStudentEmail(@PathVariable @Positive Long id, @RequestBody String newEmail) {
        newEmail = newEmail.replaceAll("[\"{}\\r\\n]", "").replace("stu_email:", "").trim();
        Student student = studentService.updateStudentEmail(id, newEmail);
        if (student != null) {
            return ResponseEntity.ok(student);
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Updates a student's password.
     *
     * @param id          the student ID
     * @param newPassword the new password (sent in request body)
     * @return ResponseEntity with the updated student or 404 if not found
     */
    @PutMapping("/updatePassword/{id}")
    public ResponseEntity<Student> updateStudentPassword(@PathVariable @Positive Long id,@RequestBody String newPassword) {
        newPassword = newPassword.replaceAll("[\"{}\\r\\n]", "").replace("stu_password:", "").trim();
        Student student = studentService.updateStudentPassword(id, newPassword);
        if (student != null) {
            return ResponseEntity.ok(student);
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Deletes a student by ID.
     *
     * @param id the student ID
     * @return ResponseEntity with a success message or 404 if not found
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable long id) {
        boolean deleted = studentService.deleteStudent(id);
        if (deleted) {
            return ResponseEntity.ok("Student deleted successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student with id" +id +"not found");
    }

}

