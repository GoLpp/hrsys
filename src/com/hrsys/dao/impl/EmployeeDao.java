package com.hrsys.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.hrsys.dao.IEmployeeDao;
import com.hrsys.pojo.Employee;
/**
 * 
 * @ClassName: EmployeeDao 
 * @Description: 员工数据访问实现类 
 * @author GG Bone
 * @date 2018年1月31日 上午9:56:29 
 *
 */
public class EmployeeDao implements IEmployeeDao{

	@Override
	public List<Employee> findAllEmployee() throws SQLException {
		return null;
	}

	@Override
	public void removeEmployee(Employee employee) throws SQLException {
		
	}

	@Override
	public void update(Employee employee) throws SQLException {
	}

	@Override
	public Employee findEmployeeById(Employee employee) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findEmployeeByCondition(Employee employee) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
