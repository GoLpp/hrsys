package com.hrsys.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.hrsys.dao.IEmployeeDao;
import com.hrsys.exception.EmployeeException;
import com.hrsys.pojo.Employee;
import com.hrsys.service.IEmployeeService;
import com.hrsys.utils.ObjectUtils;

public class EmployeeService implements IEmployeeService{
	
	private IEmployeeDao employDao = null;
	public EmployeeService() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		employDao = ObjectUtils.getObject("employeeDao");
	}
	@Override
	public List<Employee> findAllEmployee() throws SQLException {
		return employDao.findAllEmployee();
	}

	@Override
	public Employee findEmployeeById(Employee employee) throws SQLException {
		if(employee.geteId() == null) {
			throw new EmployeeException("输入参数错误");
		}
		return employDao.findEmployeeById(employee);
	}

	@Override
	public List<Employee> findEmployeeByCondition(Employee employee) throws SQLException {
		return employDao.findEmployeeByCondition(employee);
	}

	@Override
	public void removeEmployee(Employee employee) throws SQLException {
		if(null == employee.geteId()) {
			throw new EmployeeException("输入参数错误");
		}
		employDao.removeEmployee(employee);
	}

	@Override
	public void update(Employee employee) throws SQLException {
		if(employee.getdId() == null || employee.geteAddress().equals("")
				|| employee.geteCreateTime() == null 
				|| employee.geteEmail().equals("") 
				|| employee.geteGender() == null
				|| employee.geteIdCard().equals("")
				|| employee.geteName().equals("")
				|| employee.geteStu().equals("")
				|| employee.geteTelNum().equals("")
				|| employee.getjId() == null) {
			throw new EmployeeException("输入参数错误");
		}
		employDao.removeEmployee(employee);
	}

	@Override
	public void insertEmployee(Employee employee) throws SQLException {
		if(employee.getdId() == null || employee.geteAddress().equals("")
				|| employee.geteCreateTime() == null 
				|| employee.geteEmail().equals("") 
				|| employee.geteGender() == null
				|| employee.geteIdCard().equals("")
				|| employee.geteName().equals("")
				|| employee.geteStu().equals("")
				|| employee.geteTelNum().equals("")
				|| employee.getjId() == null) {
			throw new EmployeeException("输入参数错误");
		}
		employDao.insertEmployee(employee);
	}

}
