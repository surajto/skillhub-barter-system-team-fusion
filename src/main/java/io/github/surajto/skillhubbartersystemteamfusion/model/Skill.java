package io.github.surajto.skillhubbartersystemteamfusion.model;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "skill")

public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long skillId;

    @Column(nullable = false)
    private String nameOfSkill;

    @Column(nullable = false)
    private String description;

    @Column( nullable = false)
    private String level;

    @Column(nullable = false)
    private Long userId;

    // Constructors
    public Skill()
    {}

    public Skill(Long skillId, String nameOfSkill, String description, String level, Long userId) {
        this.skillId = skillId;
        this.nameOfSkill = nameOfSkill;
        this.description = description;
        this.level = level;
        this.userId = userId;
    }

    public Long getSkillId() {
        return skillId;
    }

    public void setSkillId(Long skillId) {
        this.skillId = skillId;
    }

    public String getNameOfSkill() {
        return nameOfSkill;
    }

    public void setNameOfSkill(String nameOfSkill) {
        this.nameOfSkill = nameOfSkill;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Skill skill = (Skill) o;
        return Objects.equals(skillId, skill.skillId) && Objects.equals(nameOfSkill, skill.nameOfSkill) && Objects.equals(description, skill.description) && Objects.equals(level, skill.level) && Objects.equals(userId, skill.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(skillId, nameOfSkill, description, level, userId);
    }

    @Override
    public String toString() {
        return "Skill{" +
                "skillId=" + skillId +
                ", nameOfSkill='" + nameOfSkill + '\'' +
                ", description='" + description + '\'' +
                ", level='" + level + '\'' +
                ", userId=" + userId +
                '}';
    }
}