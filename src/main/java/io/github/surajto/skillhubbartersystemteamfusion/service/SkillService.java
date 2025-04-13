package io.github.surajto.skillhubbartersystemteamfusion.service;

import io.github.surajto.skillhubbartersystemteamfusion.model.Skill;
import io.github.surajto.skillhubbartersystemteamfusion.model.Student;

import java.util.List;

public interface SkillService {

    Skill addSkill(Skill skill);

    List<Skill> getSkillsByUserId(long userId);

    List<Student> getUsersBySkillName(String skillName);

    void deleteSkill(Long skillId);
}
