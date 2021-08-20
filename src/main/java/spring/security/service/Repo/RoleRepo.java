package spring.security.service.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.security.service.domain.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
