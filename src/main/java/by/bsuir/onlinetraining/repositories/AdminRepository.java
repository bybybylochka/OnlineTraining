package by.bsuir.onlinetraining.repositories;

import by.bsuir.onlinetraining.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    @Query("SELECT a FROM Admin a WHERE a.authorizationData.login= :username")
    Optional<Admin> findByUsername(@Param("username") String username);
}
