package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hello.entity.User;
import hello.repo.UserRepository;

@RestController
public class UserController {

	//@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/users/signup")
	public String signup(@RequestBody User user) {
		System.out.println("username:" + user.getUsername() + ", password:" + user.getPassword());
		 
	 

		if (bcryptPasswordEncoder == null) {
			System.out.println("ecoder is null!!!!");
		}  {
			//user.setPassword(bcryptPasswordEncoder.encode(user.getPassword()));
			user.setPassword( user.getPassword());
			userRepository.save(user);
		}
		
		return "ok";
	}

	@RequestMapping("hello")
	public String hello() {
		return "hello";
	}
}
