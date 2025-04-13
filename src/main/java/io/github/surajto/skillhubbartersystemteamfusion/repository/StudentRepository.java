package io.github.surajto.skillhubbartersystemteamfusion.repository;

import io.github.surajto.skillhubbartersystemteamfusion.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT s FROM Student s WHERE s.stu_name = :name")
    Optional<Student> findBystu_name(@Param("name") String name);

    @Query("SELECT s FROM Student s WHERE s.stu_email= :email")
    Optional<Student> findBystu_email(@Param("email")String email);


    @Query("SELECT s FROM Student s WHERE s.stu_id = :stuId")
    List<Student> findStudentByStuId(@Param("stuId") Long stuId);

}
