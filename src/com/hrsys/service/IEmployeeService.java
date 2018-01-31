package com.hrsys.service;

import java.sql.SQLException;
import java.util.List;

import com.hrsys.pojo.Employee;

/**
 * 
 * @ClassName: IEmployeeService 
 * @Description: Ա��ҵ���߼���ӿ�
 * @author GG Bone
 * @date 2018��1��31�� ����6:52:02 
 *
 */
public interface IEmployeeService {
	/**
	 * 
	 * @Title: findAllEmployee 
	 * @Description: ��������Ա�� 
	 * @param @return
	 * @param @throws SQLException  ����˵�� 
	 * @return List<Employee>    �������� 
	 * @throws
	 */
	List<Employee> findAllEmployee() throws SQLException;
	/**
	 * 
	 * @Title: findEmployeeById 
	 * @Description: ͨ��id���� 
	 * @param @param employee
	 * @param @return
	 * @param @throws SQLException  ����˵�� 
	 * @return Employee    �������� 
	 * @throws
	 */
	Employee findEmployeeById(Employee employee) throws SQLException;
	/**
	 * 
	 * @Title: findEmployeeByCondition 
	 * @Description: ͨ���������� 
	 * @param @param employee
	 * @param @return
	 * @param @throws SQLException  ����˵�� 
	 * @return List<Employee>    �������� 
	 * @throws
	 */
	List<Employee> findEmployeeByCondition(Employee employee) throws SQLException;
	/**
	 * 
	 * @Title: removeEmployee 
	 * @Description:  ͨ���û��������ֻ��ź����֤���Ƴ��û� 
	 * @param @param employee
	 * @param @throws SQLException  ����˵�� 
	 * @return void    �������� 
	 * @throws
	 */
	void removeEmployee(Employee employee) throws SQLException;
	/**
	 * 
	 * @Title: update 
	 * @Description: ����Ա����Ϣ 
	 * @param @param employee
	 * @param @throws SQLException  ����˵�� 
	 * @return void    �������� 
	 * @throws
	 */
	void update(Employee employee) throws SQLException;
	/**
	 * 
	 * @Title: insertEmployee 
	 * @Description: ���һ��Ա��
	 * @param @param employee
	 * @param @throws SQLException  ����˵�� 
	 * @return void    �������� 
	 * @throws
	 */
	void insertEmployee(Employee employee) throws SQLException;

}
