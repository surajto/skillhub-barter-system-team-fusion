package io.github.surajto.skillhubbartersystemteamfusion.repository;

import io.github.surajto.skillhubbartersystemteamfusion.model.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    //Optional<Student> findByName(String name);

    @Query("SELECT s FROM Student s WHERE s.stu_name = :name")
    Optional<Student> findBystu_name(@Param("name")String name);

    @Query("SELECT s FROM Student s WHERE s.stu_email= :email")
    Optional<Student> findBystu_email(@Param("email")String email);

    @Modifying
    @Transactional
    @Query("UPDATE Student s SET s.stu_name = :newPhone Where s.stu_id= :id")
    void updateStudentName(@Param("newName")String newName, @Param("id")Long id);

    @Modifying
    @Transactional
    @Query("UPDATE Student s SET s.stu_phone = :newPhone Where s.stu_id= :id")
    void updateStudentPhone(@Param("newPhone")String newPhone, @Param("id")Long id);

    @Modifying
    @Transactional
    @Query("UPDATE Student s SET s.stu_email = :newPhone WHERE s.stu_id= :id")
    void updateStudentEamil(@Param("newEmail")String newEmail, @Param("id")Long id);

    @Modifying
    @Transactional
    @Query("UPDATE Student s SET s.stu_password = :newPhone WHERE s.stu_id= :id")
    void updateStudentPassword(@Param("newPassword")String newPassword, @Param("id")Long id);
}
