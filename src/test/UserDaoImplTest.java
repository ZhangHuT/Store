package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dao.impl.UserDaoImpl;
import domain.User;

class UserDaoImplTest {
	private UserDaoImpl Userdao=new UserDaoImpl();
	@Test
	void testGet() {
		User user=Userdao.get("adm");
		System.out.println(user);
	}

	@Test
	void testSave() {
		User user=new User();
		user.setName("tomcat");
		user.setPassword("123");
		Userdao.save(user);
	}

}
