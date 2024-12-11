package proyecto.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proyecto.backend.entity.UserAdmin;

import java.util.Optional;

public interface UserAdminRepository extends JpaRepository<UserAdmin, Long> {
    Optional<UserAdmin> findByUserAndPassword(String user, String password);
}
