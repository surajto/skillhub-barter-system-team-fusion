package io.github.surajto.skillhubbartersystemteamfusion.service;

import io.github.surajto.skillhubbartersystemteamfusion.exceptions.StudentNotFoundException;
import io.github.surajto.skillhubbartersystemteamfusion.model.Skill;
import io.github.surajto.skillhubbartersystemteamfusion.model.Student;

import java.util.List;

public interface SkillService {

    Skill addSkill(Skill skill) throws StudentNotFoundException;

    List<Skill> getSkillsByUserId(long userId) throws StudentNotFoundException;

    List<Student> getUsersBySkillName(String skillName) throws StudentNotFoundException;

    boolean deleteSkill(Long skillId) throws StudentNotFoundException;
}
