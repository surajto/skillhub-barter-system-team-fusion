package io.github.surajto.skillhubbartersystemteamfusion.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "skill")

public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long skillId;

    @Column(nullable = false)
    private String nameOfSkill;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String level;

    // Constructors
    public Skill() {}

    public Skill(String nameOfSkill, String description, String level) {
        this.nameOfSkill = nameOfSkill;
        this.description = description;
        this.level = level;
    }

    public Long getSkill_id() {return skillId;}

    public void setSkill_id(Long skillId) {this.skillId= skillId;}

    public String getNameOfSkill() {return nameOfSkill;}

    public void setNameOfSkill(String nameOfSkill) {this.nameOfSkill = nameOfSkill;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public String getLevel() {return level;}

    public void setLevel(String level) {this.level = level;}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Skill skill = (Skill) o;
        return Objects.equals(skillId, skill.skillId) && Objects.equals(nameOfSkill, skill.nameOfSkill) && Objects.equals(description, skill.description) && Objects.equals(level, skill.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(skillId, nameOfSkill, description, level);
    }

    @Override
    public String toString() {
        return "Skill{" +
                "skillId=" + skillId +
                ", nameOfSkill='" + nameOfSkill + '\'' +
                ", description='" + description + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
