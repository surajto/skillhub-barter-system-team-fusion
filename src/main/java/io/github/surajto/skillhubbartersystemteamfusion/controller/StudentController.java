package io.github.surajto.skillhubbartersystemteamfusion.controller;

import io.github.surajto.skillhubbartersystemteamfusion.model.Student;
import io.github.surajto.skillhubbartersystemteamfusion.service.InMemoryStudentService;
import io.github.surajto.skillhubbartersystemteamfusion.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stu")
@Validated
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(@Qualifier("databaseStudentService") StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        studentService.createStudent(student);
        return student;
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable long id){
        return studentService.getStudentById(id);
    }

    @GetMapping("/name/{name}")
    public Student getStudentByName(@PathVariable String name) {
        return studentService.getStudentByName(name);
    }

    @GetMapping("/email/{email}")
    public Student getStudentByEmail(@PathVariable String email){
        return studentService.getStudentByEmail(email);
    }

    @PutMapping("/updateName/{id}/{newName}")
    public Student updateStudentName(@PathVariable long id, @PathVariable String newName){
        Student student = studentService.getStudentById(id);
        if(student != null){
            student.setStu_name(newName);
            return student;
        }
        return null;
    }

    @PutMapping("/updatePhone/{id}/{newPhone}")
    public Student updateStudentPhone(@PathVariable long id, @PathVariable String newPhone) {
        Student student = studentService.getStudentById(id);
        if (student != null) {
            student.setStu_phone(newPhone);
            return student;
        }
        return null;
    }

    @PutMapping("/updateEmail/{id}/{newEmail}")
    public Student updateStudentEmail(@PathVariable long id, @PathVariable String newEmail) {
        Student student = studentService.getStudentById(id);
        if (student != null) {
            student.setStu_email(newEmail);
            return student;
        }
        return null;
    }

    @PutMapping("/updatePassword/{id}/{newPassword}")
    public Student updateStudentPassword(@PathVariable long id, @PathVariable String newPassword) {
        Student student = studentService.getStudentById(id);
        if (student != null) {
            student.setStu_password(newPassword);
            return student;
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public Student deleteStudentById(@PathVariable long id){
        boolean delete = studentService.deleteStudent(id);
        if (delete) {
            System.out.println("Student with id " + id + " deleted successfully");
        }
        return null;
    }
}
