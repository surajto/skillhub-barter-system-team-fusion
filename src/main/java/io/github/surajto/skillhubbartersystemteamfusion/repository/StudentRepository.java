package io.github.surajto.skillhubbartersystemteamfusion.repository;

import io.github.surajto.skillhubbartersystemteamfusion.model.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Student entity.
 * Extends JpaRepository to provide CRUD operations.
 * Contains custom queries for finding students by ID, name, and email.
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    /**
     * Retrieves a student by their ID using a custom JPQL query.
     *
     * @param id the student ID
     * @return an Optional containing the student if found, or empty otherwise
     */
    @Transactional
    @Query("SELECT s FROM Student s WHERE s.stu_id = :id")
    Optional<Student> getStudentsByStu_id(@Param("id") Long id);

    /**
     * Finds a student by their name using a custom JPQL query.
     *
     * @param name the student's name
     * @return an Optional containing the student if found, or empty otherwise
     */
    @Query("SELECT s FROM Student s WHERE s.stu_name = :name")
    Optional<Student> findBystu_name(@Param("name") String name);

    /**
     * Finds a student by their email using a custom JPQL query.
     *
     * @param email the student's email
     * @return an Optional containing the student if found, or empty otherwise
     */
    @Query("SELECT s FROM Student s WHERE s.stu_email= :email")
    Optional<Student> findBystu_email(@Param("email") String email);
}
