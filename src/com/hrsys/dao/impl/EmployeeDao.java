package com.hrsys.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.hrsys.dao.IEmployeeDao;
import com.hrsys.pojo.Employee;
/**
 * 
 * @ClassName: EmployeeDao 
 * @Description: Ա�����ݷ���ʵ���� 
 * @author GG Bone
 * @date 2018��1��31�� ����9:56:29 
 *
 */
public class EmployeeDao implements IEmployeeDao{

	@Override
	public List<Employee> findAllEmployee() throws SQLException {
		return null;
	}

	@Override
	public List<Employee> findEmployeeByJobName(Employee employee) throws SQLException {
		return null;
	}

	@Override
	public List<Employee> findEmpoyeeByGender(boolean b) throws SQLException {
		return null;
	}

	@Override
	public List<Employee> findEmployeeByDept(String deptName) throws SQLException {
		return null;
	}

	@Override
	public List<Employee> findEmployeeByInfor(Employee employee) throws SQLException {
		return null;
	}

	@Override
	public void removeEmployee(Employee employee) throws SQLException {
		
	}

	@Override
	public void update(Employee employee) throws SQLException {
	}

}
