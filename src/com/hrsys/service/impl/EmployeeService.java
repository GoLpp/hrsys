package com.hrsys.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hrsys.dao.IDepartmentDao;
import com.hrsys.dao.IEmployeeDao;
import com.hrsys.dao.IJobDao;
import com.hrsys.exception.EmployeeException;
import com.hrsys.pojo.Department;
import com.hrsys.pojo.Employee;
import com.hrsys.pojo.Job;
import com.hrsys.service.IEmployeeService;
import com.hrsys.utils.ObjectUtils;

public class EmployeeService implements IEmployeeService{
	
	private IEmployeeDao employDao = null;
	private IJobDao jobDao = null;
	private IDepartmentDao departmentDao = null;
	public EmployeeService() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		employDao = ObjectUtils.getObject("employeeDao");
		jobDao = ObjectUtils.getObject("jobDao");
		departmentDao = ObjectUtils.getObject("departmentDao");
	}
	@Override
	public List<Employee> findAllEmployee() throws SQLException {
		
		List<Employee> employees = employDao.findAllEmployee();
		List<Employee> returnEmployees = new ArrayList<>();
		return getJobAndDept(employees, returnEmployees);
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
	/**
	 * 
	 * @Title: getJobAndDept 
	 * @Description: 添加职位和部门
	 * @param @param employees
	 * @param @param returnEmployees
	 * @param @return
	 * @param @throws SQLException  参数说明 
	 * @return List<Employee>    返回类型 
	 * @throws
	 */
	private List<Employee> getJobAndDept(List<Employee> employees, List<Employee> returnEmployees) throws SQLException {
		Department dept = new Department();
		Job job = new Job();
		for(Employee employee:employees) {
			dept.setdId(employee.getdId());
			dept = departmentDao.findDeptById(dept);
			job.setjId(employee.getjId());
			job = jobDao.findJobById(job);
			employee.setDept(dept);
			employee.setJob(job);
			returnEmployees.add(employee);
		}
		return returnEmployees;
	}


}
