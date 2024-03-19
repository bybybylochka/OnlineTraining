package by.bsuir.onlinetraining.repositories;

import by.bsuir.onlinetraining.models.AuthorizationData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorizationDataRepository extends JpaRepository<AuthorizationData, Long> {
}
