package io.github.surajto.skillhubbartersystemteamfusion.controller;

import io.github.surajto.skillhubbartersystemteamfusion.model.Student;
import io.github.surajto.skillhubbartersystemteamfusion.service.InMemoryStudentService;
import io.github.surajto.skillhubbartersystemteamfusion.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
