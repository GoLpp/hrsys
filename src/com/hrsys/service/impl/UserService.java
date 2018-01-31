package com.hrsys.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.hrsys.dao.IUserDao;
import com.hrsys.exception.UserServiceException;
import com.hrsys.pojo.User;
import com.hrsys.service.IUserService;
import com.hrsys.utils.ObjectUtils;

public class UserService implements IUserService{
	private IUserDao userDao = null;
	public UserService() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		userDao = ObjectUtils.getObject("userDao");
	}
	@Override
	public void insert(User user) throws SQLException {
		if(user.getuCreateTime() == null || user.getuLoginName()==null
				|| user.getuName().equals("")
				|| user.getuPwd() == null) {
			throw new UserServiceException("输入参数错误");
		}
		userDao.insert(user);
	}

	@Override
	public List<User> findAllUser() throws SQLException {
		return userDao.findAllUser();
	}

	@Override
	public List<User> findUserByCondition(User user) throws SQLException {
		return userDao.findUserByCondition(user);
	}

	@Override
	public User findUserById(User user) throws SQLException {
		if(null == user.getuId()) {
			throw new UserServiceException("输入参数错误");
		}
		return userDao.findUserById(user);
	}

	@Override
	public void updateUser(User user) throws SQLException {
		if(user.getuCreateTime() == null || user.getuLoginName()==null
				|| user.getuName().equals("")
				|| user.getuPwd() == null) {
			throw new UserServiceException("输入参数错误");
		}
		userDao.updateUser(user);
	}

	@Override
	public void removeUser(User user) throws SQLException {
		if(null == user.getuId()) {
			throw new UserServiceException("输入参数错误");
		}
		userDao.removeUser(user);
	}

	@Override
	public User findUserByLogNameAndPwd(User user) throws SQLException {
		if(user.getuLoginName().equals("") || user.getuPwd().equals("")) {
			throw new UserServiceException("输入参数错");
		}
		User user2 = findUserByLogNameAndPwd(user);
		if(null == user2) {
			throw new UserServiceException("输入密码或登录名错误");
		}
		return user2;
	}

}
