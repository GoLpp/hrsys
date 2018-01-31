package com.hrsys.service;

import java.sql.SQLException;
import java.util.List;

import com.hrsys.pojo.Department;

/**
 * 
 * @ClassName: IDepartmentService 
 * @Description:����ҵ���߼���ӿ� 
 * @author GG Bone
 * @date 2018��1��31�� ����6:51:02 
 *
 */
public interface IDepartmentService {
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
	 * @Title: findDeptByCondition 
	 * @Description: ���������ѯ
	 * @param @return
	 * @param @throws SQLException  ����˵�� 
	 * @return List<Department>    �������� 
	 * @throws
	 */
	List<Department> findDeptByCondition(Department dept) throws SQLException;
	
	/**
	 * 
	 * @Title: findDeptById 
	 * @Description: ����id��ѯ����
	 * @param @param dept
	 * @param @return
	 * @param @throws SQLException  ����˵�� 
	 * @return List<Department>    �������� 
	 * @throws
	 */
	Department findDeptById(Department dept) throws SQLException;
	
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
	 * @Description: ����һ������
	 * @param @param dept  ����˵�� 
	 * @return void    �������� 
	 * @throws
	 */
	void insertDepartment(Department dept) throws SQLException;

}