package com.hrsys.dao;

import java.sql.SQLException;
import java.util.List;

import com.hrsys.pojo.User;
/**
 * 
 * @ClassName: IUserDao 
 * @Description:用户数据访问层 
 * @author GG Bone
 * @date 2018年1月30日 下午7:28:25 
 *
 */
public interface IUserDao {
	/**
	 * 
	 * @Title: insert 
	 * @Description: 将一个用户信息存入数据库 
	 * @param @param user
	 * @param @throws SQLException  sql异常
	 * @return void    不返回值
	 * @throws
	 */
	void insert(User user) throws SQLException;
	
	/**
	 * 
	 * @Title: findAllUser 
	 * @Description: 查找所有的用户信息 
	 * @param @return
	 * @param @throws SQLException  sql异常
	 * @return List<User>    返回一个用户集合 
	 * @throws
	 */
	List<User> findAllUser() throws SQLException;
	
	/**
	 * 
	 * @Title: updateUser 
	 * @Description: 更新用户信息 
	 * @param @param user
	 * @param @throws SQLException  sql异常
	 * @return void    不返回值
	 * @throws
	 */
	void updateUser(User user) throws SQLException;
}
