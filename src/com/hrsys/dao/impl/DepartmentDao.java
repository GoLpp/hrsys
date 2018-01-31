package com.hrsys.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.hrsys.dao.IDepartmentDao;
import com.hrsys.pojo.Department;
import com.hrsys.utils.JdbcUtils;
/**
 * 
 * @ClassName: DepartmentDao 
 * @Description: 部门数据访问层实现类 
 * @author GG Bone
 * @date 2018年1月31日 上午9:55:42 
 *
 */
public class DepartmentDao implements IDepartmentDao{

	@Override
	public List<Department> findAllDepartment() throws SQLException {
		String sql = "select * from t_department where dState=1";
		QueryRunner runner = JdbcUtils.getQueryRunner();
		return runner.query(sql, new BeanListHandler<>(Department.class));
	}

	
	@Override
	public void removeDepartment(Department dept) throws SQLException {
		String sql = "update t_department set dState=0 where dId=?";
		JdbcUtils.getQueryRunner().update(sql, dept.getdId());
	}

	@Override
	public void updateDepartment(Department dept) throws SQLException {
		String sql = "update t_department set dName=?,dDes=? where dId=?";
		JdbcUtils.getQueryRunner().update(sql, dept.getdName(),dept.getdDes(),dept.getdId());
	}

	@Override
	public void insertDepartment(Department dept) throws SQLException {
		String sql = "insert into t_department(dName,dDes) values(?,?)";
		JdbcUtils.getQueryRunner().update(sql, dept.getdName(),dept.getdDes());
	}


	@Override
	public List<Department> findDeptByCondition(Department dept) throws SQLException {
		String sql = "select * from t_department where dName=? and dState=1";
		return JdbcUtils.getQueryRunner().query(sql, new BeanListHandler<>(Department.class),"%"+dept.getdName()+"%");
	}


	@Override
	public Department findDeptById(Department dept) throws SQLException {
		String sql = "select * from t_department where dId=? and dState=1";
		return JdbcUtils.getQueryRunner().query(sql, new BeanHandler<>(Department.class),dept.getdId());
	}
}
