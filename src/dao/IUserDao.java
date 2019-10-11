package dao;

import domain.User;

/**
 * 用户数据库
 * @author thinkpad
 *
 */
public interface IUserDao {
	
	/**
	 * 用来返回数据库中的信息，如果没有该用户，返回空
	 * @param name 输入账号的名字
	 * @return 返回对应的用户或null
	 */
	public User get(String name);
	
	/**
	 * 用来保存注册的用户信息
	 * @param user 注册的用户
	 */
	public void save(User user);
}
