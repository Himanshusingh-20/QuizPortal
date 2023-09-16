package com.exam;

import com.exam.Service.UserService;
import com.exam.entity.Role;
import com.exam.entity.User;
import com.exam.entity.UserRole;
import com.exam.helper.UserFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ExamserverApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		try{
//			System.out.println("Starting code");
//			User user = new User();
//			user.setFirstName("Nikhilesh");
//			user.setLastName("Singh");
//			user.setUsername("nikhil12");
//			user.setPassword(this.bCryptPasswordEncoder.encode("abcd"));
//			user.setEmail("abc1234@gmail.com");
//			user.setProfile("default.png");
//
//			Role role = new Role();
//			role.setRoleId(45L);
//			role.setRoleName("ADMIN");
//			Set<UserRole> userRoleSet = new HashSet<>();
//			UserRole userRole = new UserRole();
//			userRole.setRole(role);
//			userRole.setUser(user);
//			userRoleSet.add(userRole);
//			User user1 = this.userService.createUser(user,userRoleSet);
//			System.out.println(user1.getUsername());
//		}catch (UserFoundException ex){
//			ex.printStackTrace();
//		}
		System.out.println("Starting Code..........");
	}
}
