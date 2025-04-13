package io.github.surajto.skillhubbartersystemteamfusion.repository;

import io.github.surajto.skillhubbartersystemteamfusion.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByName(String name);
}
