package spring.security.service.service;

import org.springframework.stereotype.Service;
import spring.security.service.domain.Role;
import spring.security.service.domain.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    Role saveRole(Role role);
    void assignRole(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
