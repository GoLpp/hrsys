package com.hrsys.dao;
/**
 * 
 * @ClassName: IDepartmentDao 
 * @Description: �������ݷ��ʲ�ӿ� 
 * @author GG Bone
 * @date 2018��1��31�� ����9:00:36 
 *
 */

import java.sql.SQLException;
import java.util.List;

import com.hrsys.pojo.Department;

public interface IDepartmentDao {
	/**
	 * 
	 * @Title: findAllDepartment 
	 * @Description: �������еĲ��� 
	 * @param @return
	 * @param @throws SQLException  ����˵�� 
	 * @return List<Department>    �������� 
	 * @throws
	 */
	List<Department> findAllDepartment() throws SQLException;
	/**
	 * 
	 * @Title: findDepartByLikeName 
	 * @Description: ģ����ѯ������Ϣ 
	 * @param @param dName
	 * @param @return  ����˵�� 
	 * @return List<Department>    �������� 
	 * @throws
	 */
	List<Department> findDepartByLikeName(String dName) throws SQLException;
	
	/**
	 * 
	 * @Title: removeDepartment 
	 * @Description: �Ƴ�һ������ 
	 * @param @param dept  ����˵�� 
	 * @return void    �������� 
	 * @throws
	 */
	void removeDepartment(Department dept) throws SQLException;
	
	/**
	 * 
	 * @Title: updateDepartment 
	 * @Description: ����һ������
	 * @param @param dept  ����˵�� 
	 * @return void    �������� 
	 * @throws
	 */
	void updateDepartment(Department dept) throws SQLException;
	
	/**
	 * 
	 * @Title: insertDepartment 
	 * @Description: ���һ������
	 * @param @param dept  ����˵�� 
	 * @return void    �������� 
	 * @throws
	 */
	void insertDepartment(Department dept) throws SQLException;
}
