package hello;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import hello.repo.PersonRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	
	//@Bean
	BCryptPasswordEncoder bcryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
//	
	@Bean
	public CommandLineRunner runnner(PersonRepository personRepo) {
		
		
		return  (args)->{
			
			
			
			System.out.println("############test###########");
			System.out.println("test");
			System.out.println("test");
			System.out.println("test");
			System.out.println("test");
			System.out.println("test");
			System.out.println("test");
			System.out.println("#################test#############");
		};
	}
	
}
