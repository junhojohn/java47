package shopping.user.test;

import java.sql.SQLException;

import shopping.user.dao.UserDao;
import shopping.user.domain.User;

public class UserTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		UserDao userDao=new UserDao();
		User user1=new User();
		
		user1.setId("ou_av");
		user1.setPassword("�ټػ��");
		user1.setName("�մټ�");
		
		userDao.addUser(user1);
		System.out.println(user1.getName()+"���� ȸ������ �Է� �Ϸ�!");
		
		User user2=userDao.findUser(user1.getId());
		System.out.println(user2.getId());
		System.out.println(user2.getPassword());
		System.out.println(user2.getName());
		System.out.println(user2.getName()+"���� ȸ������ �˻� �Ϸ�!");
	}

}
