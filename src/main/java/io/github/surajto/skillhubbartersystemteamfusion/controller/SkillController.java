package io.github.surajto.skillhubbartersystemteamfusion.controller;

import io.github.surajto.skillhubbartersystemteamfusion.model.Skill;
import io.github.surajto.skillhubbartersystemteamfusion.model.Student;
import io.github.surajto.skillhubbartersystemteamfusion.service.SkillService;
import io.github.surajto.skillhubbartersystemteamfusion.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/skills")
@Validated
public class SkillController {

    private final SkillService skillService;
    private final StudentService studentService;

    @Autowired
    public SkillController(SkillService skillService, @Qualifier("databaseStudentService") StudentService studentService) {
        this.skillService = skillService;
        this.studentService = studentService;
    }

    /**
     * Add a new skill to student.
     *
     * @param skill The skill information to add
     * @return The add skill with HTTP status 201 (created)
     */
    @PostMapping("/add")
    public ResponseEntity<Skill> addSkill(@RequestBody Skill skill) {
        Skill addedSkill = skillService.addSkill(skill);
        return new ResponseEntity<>(addedSkill, HttpStatus.CREATED);
    }



    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Skill>> getSkillsByUserId(@PathVariable Long userId){
        List<Skill> skill = skillService.getSkillsByUserId(userId);
        if (skill != null) {
            return ResponseEntity.ok(skill);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/name/{skillName}")
    public ResponseEntity<List<Student>> getStudentsBySkill(@PathVariable String skillName) {
        List<Student> students = skillService.getUsersBySkillName(skillName);
        if (students.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(students);
    }


    @DeleteMapping("/delete/{skillId}")
    public ResponseEntity<String> deleteSkill(@PathVariable Long skillId) {
        boolean deleted = skillService.deleteSkill(skillId);
        if (deleted) {
            return ResponseEntity.ok("Skill deleted successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Skill not found");
    }
}
