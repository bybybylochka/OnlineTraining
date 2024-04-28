package by.bsuir.onlinetraining.repositories;

import by.bsuir.onlinetraining.models.Entrepreneur;
import by.bsuir.onlinetraining.models.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MentorRepository extends JpaRepository<Mentor, Long> {
    @Query("SELECT m FROM Mentor m WHERE m.authorizationData.login= :username")
    Optional<Mentor> findByUsername(@Param("username") String username);

    List<Mentor> findAllByAddedBy(Entrepreneur entrepreneur);
}
