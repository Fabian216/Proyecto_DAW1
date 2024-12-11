package proyecto.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proyecto.backend.entity.UserAdmin;

public interface UserAdminRepository extends JpaRepository<UserAdmin, Long> {
}
