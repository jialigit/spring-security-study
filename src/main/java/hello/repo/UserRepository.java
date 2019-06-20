package hello.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import hello.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{

	User findByUsername(String username);
}
