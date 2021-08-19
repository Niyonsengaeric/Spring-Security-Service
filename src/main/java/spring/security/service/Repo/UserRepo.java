package spring.security.service.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.security.service.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
