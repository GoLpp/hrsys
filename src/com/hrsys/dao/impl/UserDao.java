package com.hrsys.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.hrsys.dao.IUserDao;
import com.hrsys.pojo.User;
import com.hrsys.utils.JdbcUtils;
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
		String sql = "insert into t_user(uName,uPwd,uLoginName,uCreateTime,uState) "
				+ "values(?,?,?,?,?)";
		JdbcUtils.getQueryRunner().update(sql, user.getuName(),user.getuPwd(),
				user.getuLoginName(),
				new Date(),user.getuState());
	}

	@Override
	public List<User> findAllUser() throws SQLException {
		String sql = "select *from t_user where uState<>0";
		return JdbcUtils.getQueryRunner().query(sql, new BeanListHandler<>(User.class));
	}

	@Override
	public void updateUser(User user) throws SQLException {
		String sql = "update t_user set uName=?,uPwd=?,uLoginName=?,uCreateTime=?,uState=? "
				+ "where uId=?";
		JdbcUtils.getQueryRunner().update(sql, user.getuName(),user.getuPwd(),
				user.getuLoginName(),new Date(),user.getuState(),user.getuId());
	}

	@Override
	public void removeUser(User user) throws SQLException {
		String sql = "update t_user set uState=0 where uId=?";
		JdbcUtils.getQueryRunner().update(sql,user.getuId());
	}

	@Override
	public List<User> findUserByCondition(User user) throws SQLException {
		StringBuilder sql = new StringBuilder("select *from t_user where 1=1 and uState<>0");
		if(user.getuName()!=null && !user.getuName().equals("")) {
			sql.append(" and uName like '%"+user.getuName()+"%'");
		}
		if(user.getuState()!=null && user.getuState()!=0) {
			sql.append(" and uState like '%"+user.getuState()+"%'");
		}
		System.out.println(sql.toString());
		return JdbcUtils.getQueryRunner().query(sql.toString(), new BeanListHandler<>(User.class));

	}

	@Override
	public User findUserById(User user) throws SQLException {
		String sql = "select *from t_user where uId=? and uState<>0";
		return JdbcUtils.getQueryRunner().query(sql, new BeanHandler<>(User.class),user.getuId());
	}

	@Override
	public User findUserByLogNameAndPwd(User user) throws SQLException {
		String sql = "select *from t_user where uLoginName=? and uPwd=? and uState<>0";
		return JdbcUtils.getQueryRunner().query(sql, new BeanHandler<>(User.class),user.getuLoginName(),user.getuPwd());
	}

}
