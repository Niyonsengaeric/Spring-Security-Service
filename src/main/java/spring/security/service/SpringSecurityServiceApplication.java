package spring.security.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import spring.security.service.domain.Role;
import spring.security.service.domain.User;
import spring.security.service.service.UserService;

import java.util.ArrayList;

@SpringBootApplication
public class SpringSecurityServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityServiceApplication.class, args);
	}
@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
}
	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null,"ROLE_USER"));
			userService.saveRole(new Role(null,"ROLE_MANAGER"));
			userService.saveRole(new Role(null,"ROLE_ADMIN"));
			userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null,"John Doe","doe","1234",new ArrayList<>()));
			userService.saveUser(new User(null,"William Messi","william","1234",new ArrayList<>()));
			userService.saveUser(new User(null,"Babu Scum","babu","1234",new ArrayList<>()));


		    userService.assignRole("doe","ROLE_USER");
			userService.assignRole("doe","ROLE_MANAGER");
			userService.assignRole("william","ROLE_MANAGER");
			userService.assignRole("babu","ROLE_SUPER_ADMIN");
			userService.assignRole("babu","ROLE_ADMIN");
			userService.assignRole("babu","ROLE_MANAGER");

		};
	}

}
