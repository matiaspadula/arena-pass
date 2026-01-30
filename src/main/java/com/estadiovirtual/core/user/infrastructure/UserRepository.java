package com.estadiovirtual.core.user.infrastructure;
import com.estadiovirtual.core.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> { //la interfaz gestiona entidad User, cuyo ID es long
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
}