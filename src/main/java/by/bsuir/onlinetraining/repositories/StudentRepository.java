package by.bsuir.onlinetraining.repositories;

import by.bsuir.onlinetraining.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT s FROM Student s WHERE s.authorizationData.login= :username")
    Optional<Student> findByUsername(@Param("username") String username);
}
