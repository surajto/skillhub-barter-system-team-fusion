package io.github.surajto.skillhubbartersystemteamfusion.model;


import jakarta.persistence.*;

@Entity
@Table(name = "skill")
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private long skill_id;

    @Column(nullable = false)
    private String skill_name;

    @Column(nullable = false)
    private String skill_description;

    @Column(nullable = false)
    private String skill_level;

    /**
     * This is foreign key so that we can find out which user have which skills
     */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Student student;

    public Skills() {
    }

    public Skills(long skill_id, String skill_name, String skill_description, String skill_level, Student student) {
        this.skill_id = skill_id;
        this.skill_name = skill_name;
        this.skill_description = skill_description;
        this.skill_level = skill_level;
        this.student = student;
    }

    public long getSkill_id() {return skill_id;}

    public void setSkill_id(long skill_id) {this.skill_id = skill_id;}

    public String getSkill_name() {return skill_name;}

    public void setSkill_name(String skill_name) {this.skill_name = skill_name;}

    public String getSkill_description() {return skill_description;}

    public void setSkill_description(String skill_description) {this.skill_description = skill_description;}

    public String getSkill_level() {return skill_level;}

    public void setSkill_level(String skill_level) {this.skill_level = skill_level;}

    public Student getStudent() {return student;}

    public void setStudent(Student student) {this.student = student;}
}
