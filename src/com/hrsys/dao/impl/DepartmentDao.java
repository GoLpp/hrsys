package com.hrsys.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.hrsys.dao.IDepartmentDao;
import com.hrsys.pojo.Department;
/**
 * 
 * @ClassName: DepartmentDao 
 * @Description: �������ݷ��ʲ�ʵ���� 
 * @author GG Bone
 * @date 2018��1��31�� ����9:55:42 
 *
 */
public class DepartmentDao implements IDepartmentDao{

	@Override
	public List<Department> findAllDepartment() throws SQLException {
		return null;
	}

	
	@Override
	public void removeDepartment(Department dept) throws SQLException {
		
	}

	@Override
	public void updateDepartment(Department dept) throws SQLException {
		
	}

	@Override
	public void insertDepartment(Department dept) throws SQLException {
		
	}


	@Override
	public List<Department> findDeptByCondition(Department dept) throws SQLException {
		return null;
	}


	@Override
	public Department findDeptById(Department dept) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
