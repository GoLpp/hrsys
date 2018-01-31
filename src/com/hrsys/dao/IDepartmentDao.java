package com.hrsys.dao;
/**
 * 
 * @ClassName: IDepartmentDao 
 * @Description: 部门数据访问层接口 
 * @author GG Bone
 * @date 2018年1月31日 上午9:00:36 
 *
 */

import java.sql.SQLException;
import java.util.List;

import com.hrsys.pojo.Department;

public interface IDepartmentDao {
	/**
	 * 
	 * @Title: findAllDepartment 
	 * @Description: 查找所有的部门 
	 * @param @return
	 * @param @throws SQLException  参数说明 
	 * @return List<Department>    返回类型 
	 * @throws
	 */
	List<Department> findAllDepartment() throws SQLException;
	/**
	 * 
	 * @Title: findDeptByCondition 
	 * @Description: 组合条件查询
	 * @param @return
	 * @param @throws SQLException  参数说明 
	 * @return List<Department>    返回类型 
	 * @throws
	 */
	List<Department> findDeptByCondition(Department dept) throws SQLException;
	
	/**
	 * 
	 * @Title: findDeptById 
	 * @Description: 根据id查询部门
	 * @param @param dept
	 * @param @return
	 * @param @throws SQLException  参数说明 
	 * @return List<Department>    返回类型 
	 * @throws
	 */
	Department findDeptById(Department dept) throws SQLException;
	
	/**
	 * 
	 * @Title: removeDepartment 
	 * @Description: 移除一个部门 
	 * @param @param dept  参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	void removeDepartment(Department dept) throws SQLException;
	
	/**
	 * 
	 * @Title: updateDepartment 
	 * @Description: 更新一个部门
	 * @param @param dept  参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	void updateDepartment(Department dept) throws SQLException;
	
	/**
	 * 
	 * @Title: insertDepartment 
	 * @Description: 添加一个部门
	 * @param @param dept  参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	void insertDepartment(Department dept) throws SQLException;
}
