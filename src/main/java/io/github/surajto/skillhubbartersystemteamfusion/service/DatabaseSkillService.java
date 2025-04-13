package io.github.surajto.skillhubbartersystemteamfusion.service;

import io.github.surajto.skillhubbartersystemteamfusion.exceptions.StudentNotFoundException;
import io.github.surajto.skillhubbartersystemteamfusion.exceptions.StudentValidationException;
import io.github.surajto.skillhubbartersystemteamfusion.model.Skill;
import io.github.surajto.skillhubbartersystemteamfusion.model.Student;
import io.github.surajto.skillhubbartersystemteamfusion.repository.SkillRepository;
import io.github.surajto.skillhubbartersystemteamfusion.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class DatabaseSkillService implements SkillService {

    private final SkillRepository skillRepository;
    private final StudentRepository studentRepository;

    public DatabaseSkillService(SkillRepository skillRepository, StudentRepository studentRepository) {
        this.skillRepository = skillRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public Skill addSkill(Skill skill) {
        if (skill.getNameOfSkill() == null || skill.getNameOfSkill().isBlank()) {
            throw new StudentValidationException("Skill name cannot be empty");
        }

        if (skill.getDescription() == null || skill.getDescription().isBlank()) {
            throw new StudentValidationException("Skill description cannot be empty");
        }

        Long id = skill.getUserId();
        if(skill.getUserId() == null){
            throw new StudentValidationException("User id cannot be null");
        }

        if (studentRepository.findStudentByStuId(skill.getUserId()).isEmpty()) {
            throw new StudentNotFoundException("Student not found");
        }


        String level = skill.getLevel();
        if (level == null || (!level.equalsIgnoreCase("basic") &&
                !level.equalsIgnoreCase("intermediate") &&
                !level.equalsIgnoreCase("pro"))) {
            throw new StudentValidationException("Level must be one of: basic, intermediate, or pro");
        }
        return skillRepository.save(skill);
    }


    @Override
    public List<Skill> getSkillsByUserId(long userId){
        if (studentRepository.findStudentByStuId(userId).isEmpty()) {
            throw new StudentNotFoundException("Student not found");
        }
        List<Skill> skills = new ArrayList<>();
        skills = skillRepository.findSkillsByUserId(userId);
        if(skills.isEmpty()){
            return null;
        }
        return skills;
    }

    @Override
    public List<Student> getUsersBySkillName(String skillName) {
        List<Long> ids = skillRepository.findUserIdsBySkillName(skillName);
        if (ids.isEmpty()) {
            throw new RuntimeException("Can't find the skill specified");
        }

        List<Student> students = new ArrayList<>();
        for (Long stu_id : ids) {
            List<Student> foundStudents = studentRepository.findStudentByStuId(stu_id);
            students.addAll(foundStudents);
        }
        return students;
    }


    @Override
    public boolean deleteSkill(Long skillId) {
        if(skillRepository.existsById(skillId)){
            skillRepository.deleteById(skillId);
            return true;
        }
        return false;
    }
}
