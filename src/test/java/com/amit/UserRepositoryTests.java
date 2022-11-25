package com.amit;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.amit.model.Users;
import com.amit.repository.UsersRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)

@Rollback(false)
public class UserRepositoryTests {

	@Autowired
	private UsersRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUser() {
		Users users = new Users();
		users.setEmail("abc@gmail.com");
		users.setPassword("abc@123");
		users.setAddress("Mumbai");
		users.setAge("42");
		users.setAincome("500000");
		users.setDeposit("66000");
		users.setMexpense("17000");
		users.setMobileNo("9898090000");
		users.setName("abckumar");
		users.setPropValue("1800000");
		
		Users savedUser = repo.save(users);
		
		Users existUser = entityManager.find(Users.class, savedUser.getEmail());
		
		assertThat(existUser.getEmail()).isEqualTo(users.getEmail());
	}
}
