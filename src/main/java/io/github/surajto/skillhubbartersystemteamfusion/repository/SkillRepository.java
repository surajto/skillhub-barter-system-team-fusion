package io.github.surajto.skillhubbartersystemteamfusion.repository;

import io.github.surajto.skillhubbartersystemteamfusion.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
    List<Skill> findSkillsByUserId(long userId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Skill s WHERE s.skillId = :skillId")
    int deleteBySkillId(@Param("skillId") Long skillId);


    @Query("SELECT s.userId FROM Skill s WHERE s.nameOfSkill = :skillName")
    List<Long> findUserIdsBySkillName(@Param("skillName") String skillName);

}
