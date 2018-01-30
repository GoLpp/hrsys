package com.hrsys.dao;

import java.sql.SQLException;

import com.hrsys.pojo.Job;
/**
 * 
 * @ClassName: IJobDao 
 * @Description: 职位的数据访问层接口 
 * @author GG Bone
 * @date 2018年1月30日 下午8:15:41 
 *
 */
public interface IJobDao {
	void insert(Job job) throws SQLException;
	void findAllJob() throws SQLException;
}
