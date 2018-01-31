package com.hrsys.dao;

import java.sql.SQLException;
import java.util.List;

import com.hrsys.pojo.Employee;
/**
 * 
 * @ClassName: IEmployeeDao 
 * @Description: 员工数据访问层接口 
 * @author GG Bone
 * @date 2018年1月31日 上午9:35:17 
 *
 */
public interface IEmployeeDao {
	/**
	 * 
	 * @Title: findAllEmployee 
	 * @Description: 查找所有员工 
	 * @param @return
	 * @param @throws SQLException  参数说明 
	 * @return List<Employee>    返回类型 
	 * @throws
	 */
	List<Employee> findAllEmployee() throws SQLException;
	/**
	 * 
	 * @Title: findEmployeeByJobName 
	 * @Description: 通过职位查找员工 
	 * @param @param employee
	 * @param @return
	 * @param @throws SQLException  参数说明 
	 * @return List<Employee>    返回类型 
	 * @throws
	 */
	List<Employee> findEmployeeByJobName(Employee employee) throws SQLException;
	/**
	 * 
	 * @Title: findEmpoyeeByGender 
	 * @Description: 通过性别查找员工
	 * @param @param b
	 * @param @return
	 * @param @throws SQLException  参数说明 
	 * @return List<Employee>    返回类型 
	 * @throws
	 */
	List<Employee> findEmpoyeeByGender(boolean b) throws SQLException;
	/**
	 * 
	 * @Title: findEmployeeByDept 
	 * @Description: 通过部门查找员工 
	 * @param @param deptName
	 * @param @return
	 * @param @throws SQLException  参数说明 
	 * @return List<Employee>    返回类型 
	 * @throws
	 */
	List<Employee> findEmployeeByDept(String deptName) throws SQLException;
	/**
	 * 
	 * @Title: findEmployeeByInfor 
	 * @Description: 通过用户的姓名手机号和身份证号查找用户 
	 * @param @param employee
	 * @param @return
	 * @param @throws SQLException  参数说明 
	 * @return List<Employee>    返回类型 
	 * @throws
	 */
	List<Employee> findEmployeeByInfor(Employee employee) throws SQLException;
	
	/**
	 * 
	 * @Title: removeEmployee 
	 * @Description:  通过用户的姓名手机号和身份证号移除用户 
	 * @param @param employee
	 * @param @throws SQLException  参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	void removeEmployee(Employee employee) throws SQLException;
	/**
	 * 
	 * @Title: update 
	 * @Description: 更新员工信息 
	 * @param @param employee
	 * @param @throws SQLException  参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	void update(Employee employee) throws SQLException;
}
