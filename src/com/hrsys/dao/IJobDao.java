package com.hrsys.dao;

import java.sql.SQLException;

import com.hrsys.pojo.Job;
/**
 * 
 * @ClassName: IJobDao 
 * @Description: ְλ�����ݷ��ʲ�ӿ� 
 * @author GG Bone
 * @date 2018��1��30�� ����8:15:41 
 *
 */
public interface IJobDao {
	void insert(Job job) throws SQLException;
	void findAllJob() throws SQLException;
}
