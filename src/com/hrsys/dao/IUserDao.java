package com.hrsys.dao;

import java.sql.SQLException;
import java.util.List;

import com.hrsys.pojo.User;
/**
 * 
 * @ClassName: IUserDao 
 * @Description:�û����ݷ��ʲ� 
 * @author GG Bone
 * @date 2018��1��30�� ����7:28:25 
 *
 */
public interface IUserDao {
	/**
	 * 
	 * @Title: insert 
	 * @Description: ��һ���û���Ϣ�������ݿ� 
	 * @param @param user
	 * @param @throws SQLException  sql�쳣
	 * @return void    ������ֵ
	 * @throws
	 */
	void insert(User user) throws SQLException;
	
	/**
	 * 
	 * @Title: findAllUser 
	 * @Description: �������е��û���Ϣ 
	 * @param @return
	 * @param @throws SQLException  sql�쳣
	 * @return List<User>    ����һ���û����� 
	 * @throws
	 */
	List<User> findAllUser() throws SQLException;
	/**
	 * 
	 * @Title: findUserByCondition 
	 * @Description: ͨ���������� 
	 * @param @param user
	 * @param @return
	 * @param @throws SQLException  ����˵�� 
	 * @return List<User>    �������� 
	 * @throws
	 */
	List<User> findUserByCondition(User user) throws SQLException;
	/**
	 * 
	 * @Title: findUserById 
	 * @Description: ͨ��id���� 
	 * @param @param user
	 * @param @return
	 * @param @throws SQLException  ����˵�� 
	 * @return User    �������� 
	 * @throws
	 */
	User findUserById(User user) throws SQLException;
	
	/**
	 * 
	 * @Title: updateUser 
	 * @Description: �����û���Ϣ 
	 * @param @param user
	 * @param @throws SQLException  sql�쳣
	 * @return void    ������ֵ
	 * @throws
	 */
	void updateUser(User user) throws SQLException;
	
	/**
	 * 
	 * @Title: removeUser 
	 * @Description: �Ƴ��û� 
	 * @param @param user
	 * @param @throws SQLException  ����˵�� 
	 * @return void    �������� 
	 * @throws
	 */
	void removeUser(User user) throws SQLException;
	
	/**
	 * 
	 * @Title: findUserByLogNameAndPwd 
	 * @Description: ��¼��֤ 
	 * @param @param user
	 * @param @return
	 * @param @throws SQLException  ����˵�� 
	 * @return User    �������� 
	 * @throws
	 */
	User findUserByLogNameAndPwd(User user) throws SQLException;

	User findAnyUserById(User user) throws SQLException;	
}
