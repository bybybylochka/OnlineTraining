package by.bsuir.onlinetraining.repositories;

import by.bsuir.onlinetraining.models.Entrepreneur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EntrepreneurRepository extends JpaRepository<Entrepreneur, Long> {
    @Query("SELECT e FROM Entrepreneur e WHERE e.authorizationData.login= :username")
    Optional<Entrepreneur> findByUsername(@Param("username") String username);
}
