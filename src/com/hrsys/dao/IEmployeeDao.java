package com.hrsys.dao;

import java.sql.SQLException;
import java.util.List;

import com.hrsys.pojo.Employee;
/**
 * 
 * @ClassName: IEmployeeDao 
 * @Description: Ա�����ݷ��ʲ�ӿ� 
 * @author GG Bone
 * @date 2018��1��31�� ����9:35:17 
 *
 */
public interface IEmployeeDao {
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
	 * @Title: findEmployeeByJobName 
	 * @Description: ͨ��ְλ����Ա�� 
	 * @param @param employee
	 * @param @return
	 * @param @throws SQLException  ����˵�� 
	 * @return List<Employee>    �������� 
	 * @throws
	 */
	List<Employee> findEmployeeByJobName(Employee employee) throws SQLException;
	/**
	 * 
	 * @Title: findEmpoyeeByGender 
	 * @Description: ͨ���Ա����Ա��
	 * @param @param b
	 * @param @return
	 * @param @throws SQLException  ����˵�� 
	 * @return List<Employee>    �������� 
	 * @throws
	 */
	List<Employee> findEmpoyeeByGender(boolean b) throws SQLException;
	/**
	 * 
	 * @Title: findEmployeeByDept 
	 * @Description: ͨ�����Ų���Ա�� 
	 * @param @param deptName
	 * @param @return
	 * @param @throws SQLException  ����˵�� 
	 * @return List<Employee>    �������� 
	 * @throws
	 */
	List<Employee> findEmployeeByDept(String deptName) throws SQLException;
	/**
	 * 
	 * @Title: findEmployeeByInfor 
	 * @Description: ͨ���û��������ֻ��ź����֤�Ų����û� 
	 * @param @param employee
	 * @param @return
	 * @param @throws SQLException  ����˵�� 
	 * @return List<Employee>    �������� 
	 * @throws
	 */
	List<Employee> findEmployeeByInfor(Employee employee) throws SQLException;
	
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
}
