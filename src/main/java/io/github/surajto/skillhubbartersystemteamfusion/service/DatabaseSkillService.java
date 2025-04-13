package io.github.surajto.skillhubbartersystemteamfusion.service;

import io.github.surajto.skillhubbartersystemteamfusion.model.Skill;
import io.github.surajto.skillhubbartersystemteamfusion.model.Student;
import io.github.surajto.skillhubbartersystemteamfusion.repository.SkillRepository;
import io.github.surajto.skillhubbartersystemteamfusion.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class DatabaseSkillService implements SkillService {

    private final SkillRepository skillRepository;
    private final StudentRepository studentRepository;

    public DatabaseSkillService(SkillRepository skillRepository,StudentRepository studentRepository) {
        this.skillRepository = skillRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public Skill addSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    @Override
    public List<Skill> getSkillsByUserId(long userId) {
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
        List<Student> students = new ArrayList<>();
        for(Long stu_id:ids){
            students = studentRepository.findStudentByStuId(stu_id);
        }
        return students;
    }


    @Override
    @Transactional
    public void deleteSkill(Long skillId) {
         skillRepository.deleteBySkillId(skillId);
    }
}
