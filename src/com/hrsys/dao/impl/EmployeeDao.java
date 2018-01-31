package com.hrsys.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.hrsys.dao.IEmployeeDao;
import com.hrsys.pojo.Employee;
import com.hrsys.utils.JdbcUtils;
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
		String sql = "select *from t_employee where eState=1";
		return JdbcUtils.getQueryRunner().query(sql, new BeanListHandler<>(Employee.class));
	}

	@Override
	public void removeEmployee(Employee employee) throws SQLException {
		String sql = "update t_employee set eState=0 where eId=?";
		JdbcUtils.getQueryRunner().update(sql, employee.geteId());
	}

	@Override
	public void update(Employee employee) throws SQLException {
		String sql = "update t_employee set eName=?,eGender=?,eTelNum=?,"
				+ "eEmail=?,jId=?,eStu=?,dId=?,eIdCard=?,eCreateTime=?,eAddress=? "
				+ " where eId=?";
		JdbcUtils.getQueryRunner().update(sql, employee.geteName(),
				employee.geteGender(),
				employee.geteTelNum(),
				employee.geteEmail(),
				employee.getjId(),
				employee.geteStu(),
				employee.getdId(),
				employee.geteIdCard(),
				employee.geteCreateTime(),
				employee.geteAddress(),
				employee.geteId());
	}

	@Override
	public Employee findEmployeeById(Employee employee) throws SQLException {
		String sql = "select *from t_employee where eId=? and eState=1";
		return JdbcUtils.getQueryRunner().query(sql,new BeanHandler<>(Employee.class),employee.geteId());
	}

	@Override
	public List<Employee> findEmployeeByCondition(Employee employee) throws SQLException {
		StringBuilder sql = new StringBuilder("select *from t_employee where 1=1 and eState=1");	
		handleSql(employee, sql);
		return JdbcUtils.getQueryRunner().query(sql.toString(), new BeanListHandler<>(Employee.class));
	}

	@Override
	public void insertEmployee(Employee employee) throws SQLException {
		String sql = "insert into t_employee(eName,eGender,eTelNum,eEmail,jId,"
				+ "eStu,dId,eIdCard,eCreateTime,eAddress) values(?,?,?,?,?,?,?,?,?,?)";
		JdbcUtils.getQueryRunner().update(sql,employee.geteName(),
				employee.geteGender(),
				employee.geteTelNum(),
				employee.geteEmail(),
				employee.getjId(),
				employee.geteStu(),
				employee.getdId(),
				employee.geteIdCard(),
				employee.geteCreateTime(),
				employee.geteAddress());
	}
/**
 * 
 * @Title: handleSql 
 * @Description: 动态生成sql 
 * @param @param employee
 * @param @param sql  参数说明 
 * @return void    返回类型 
 * @throws
 */
	private void handleSql(Employee employee, StringBuilder sql) {
		if(employee.geteName()!=null && !employee.geteName().equals("")) {
			sql.append(" and eName='%"+employee.geteName()+"%'");
		}
		if(employee.getdId() != null) {
			sql.append(" and dId='%"+employee.getdId()+"%'");
		}
		if(employee.geteGender() != null) {
			sql.append(" and eGender='"+employee.geteGender()+"'");
		}
		if(employee.geteTelNum() != null && !employee.geteTelNum().equals("")) {
			sql.append(" and eTelNum='%"+employee.geteTelNum()+"%'");
		}
		if(employee.geteIdCard() != null && !employee.geteIdCard().equals("")) {
			sql.append(" and eIdCard='%"+employee.geteIdCard()+"%'");
		}
		if(employee.getdId() != null) {
			sql.append(" and dId='%"+employee.getdId()+"%'");
		}
	}
}
