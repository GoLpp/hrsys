package com.hrsys.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.hrsys.dao.IDepartmentDao;
import com.hrsys.exception.DepartmentException;
import com.hrsys.pojo.Department;
import com.hrsys.service.IDepartmentService;
import com.hrsys.utils.ObjectUtils;

public class DepartmentService implements IDepartmentService{
	private IDepartmentDao deptDao = null;
	
	public DepartmentService() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		deptDao = ObjectUtils.getObject("departmentDao");
	}
	@Override
	public List<Department> findAllDepartment() throws SQLException {
		return deptDao.findAllDepartment();
	}

	@Override
	public List<Department> findDeptByCondition(Department dept) throws SQLException {
		return deptDao.findDeptByCondition(dept);
	}

	@Override
	public Department findDeptById(Department dept) throws SQLException {
		if(dept.getdId() == null) {
			throw new DepartmentException("输入参数错误");
		}
		return deptDao.findDeptById(dept);
	}

	@Override
	public void removeDepartment(Department dept) throws SQLException {
		if(dept.getdId() == null) {
			throw new DepartmentException("输入参数错误");
		}
		deptDao.removeDepartment(dept);
	}

	@Override
	public void updateDepartment(Department dept) throws SQLException {
		if(dept.getdDes().equals("")|| dept.getdName().equals("")) {
			throw new DepartmentException("输入参数错误");
		}
		deptDao.updateDepartment(dept);
	}

	@Override
	public void insertDepartment(Department dept) throws SQLException {
		if(dept.getdDes().equals("") || dept.getdName().equals("")) {
			throw new DepartmentException("输入参数错误");
		}
		deptDao.insertDepartment(dept);
	}

}
