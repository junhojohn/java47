package shopping.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import shopping.db.util.DbUtil;
import shopping.user.domain.User;

public class UserDao {
	DbUtil dbUtil=null;
	
	public UserDao(){
		dbUtil=new DbUtil();
	}
	
	public void addUser(User user) throws ClassNotFoundException, SQLException{
		
		Connection c=dbUtil.getConnection();
		
		PreparedStatement pstmt=c.prepareStatement("INSERT INTO users (id, password, name) VALUES(?,?,?)");
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getName());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		c.close();
	}
	
	public User findUser(String id) throws ClassNotFoundException, SQLException{
		
		Connection c=dbUtil.getConnection();
		
		PreparedStatement pstmt=c.prepareStatement("SELECT * FROM users WHERE id=?");
		pstmt.setString(1, id);
		
		ResultSet rs=pstmt.executeQuery();
		User user=new User();
		while(rs.next()){
			user.setId(rs.getString("id"));
			user.setPassword(rs.getString("password"));
			user.setName(rs.getString("name"));
		}
		rs.close();
		pstmt.close();
		c.close();
		
		return user;
	}
}
