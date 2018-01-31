package com.hrsys.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.hrsys.dao.IUserDao;
import com.hrsys.pojo.User;
/**
 * 
 * @ClassName: UserDao 
 * @Description: 用户数据访问实现类 
 * @author GG Bone
 * @date 2018年1月31日 上午9:57:41 
 *
 */
public class UserDao implements IUserDao{

	@Override
	public void insert(User user) throws SQLException {
		
	}

	@Override
	public List<User> findAllUser() throws SQLException {
		return null;
	}

	@Override
	public void updateUser(User user) throws SQLException {
		
	}

	@Override
	public void removeUser(User user) throws SQLException {
		
	}

	@Override
	public List<User> findUserByCondition(User user) throws SQLException {
		return null;
	}

	@Override
	public User findUserById(User user) throws SQLException {
		return null;
	}

}
