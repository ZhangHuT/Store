package dao.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import dao.IUserDao;
import domain.User;

//登陆账号的实现
public class UserDaoImpl implements IUserDao{
	
	//用来读取resource中的dp.properties文件
	private static Properties pre=new Properties();
	
	static {
		try {
			pre.load(UserDaoImpl.class.getResourceAsStream("/dp.properties"));
			Class.forName(pre.getProperty("classDriverName"));//加载驱动器
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("驱动器加载失败");
		}
	}

	private Connection getConnection() {
		Connection conn=null;
		try {
			return DriverManager.getConnection(pre.getProperty("url"),pre.getProperty("username"),pre.getProperty("password"));
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("连接数据库失败");
		}
		return conn;
	}
	
	public User get(String name) {
		Connection conn=null;
		User user=null;
		PreparedStatement pre=null;
		ResultSet res=null;
		String sql="SELECT * FROM login WHERE username=?";
		try {
			conn=getConnection();
			pre=conn.prepareStatement(sql);
			pre.setString(1, name);
			res=pre.executeQuery();
			if(res.next()) {
				user=new User();
				user.setId(res.getInt("id"));
				user.setName(res.getString("username"));
				user.setPassword(res.getString("password"));
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("获取用户数据失败");
		}finally {
			//关闭资源
			if(res!=null) {
				try {
					res.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
				}finally {
					if(pre!=null) {
						try {
							pre.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}finally {
							try {
								conn.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
		return user;
	}

	public void save(User user) {
		Connection conn=null;
		PreparedStatement pre=null;
		ResultSet res=null;
		String sql="INSERT INTO login(username,password) values(?,?)";
		try {
			conn=getConnection();
			pre=conn.prepareStatement(sql);
			pre.setString(1, user.getName());
			pre.setString(2, user.getPassword());
			pre.execute();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("添加用户失败");
		}finally {

			//关闭资源
			if(res!=null) {
				try {
					res.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
				}finally {
					if(pre!=null) {
						try {
							pre.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}finally {
							try {
								conn.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		
		}
	}

}
