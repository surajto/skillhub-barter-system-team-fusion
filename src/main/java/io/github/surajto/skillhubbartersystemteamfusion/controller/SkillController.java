package io.github.surajto.skillhubbartersystemteamfusion.controller;

import io.github.surajto.skillhubbartersystemteamfusion.model.Skill;
import io.github.surajto.skillhubbartersystemteamfusion.model.Student;
import io.github.surajto.skillhubbartersystemteamfusion.service.SkillService;
import io.github.surajto.skillhubbartersystemteamfusion.service.StudentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/skills")
public class SkillController {

    private final SkillService skillService;
    private final StudentService studentService;

    public SkillController(SkillService skillService, @Qualifier("databaseStudentService") StudentService studentService) {
        this.skillService = skillService;
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public Skill addSkill(@RequestBody Skill skill) {
        return skillService.addSkill(skill);
    }

    @GetMapping("/user/{userId}")
    public List<Skill> getSkillsByUserId(@PathVariable Long userId){
        return skillService.getSkillsByUserId(userId);
    }

    @GetMapping("/name/{skillName}")
    public List<Student> getStudentsBySkill(@PathVariable String skillName) {
        List<Student> students = skillService.getUsersBySkillName(skillName);

        if (students.isEmpty()) {
            return null;
        }
        return students;
    }


    @DeleteMapping("/delete/{skillId}")
    public void deleteSkill(@PathVariable Long skillId) {
        skillService.deleteSkill(skillId);
    }
}
