package com.hrsys.dao;

import java.sql.SQLException;
import com.hrsys.pojo.Notice;
/**
 * 
 * @ClassName: INoticeDao 
 * @Description: �������ݷ��ʽӿ�
 * @author GG Bone
 * @date 2018��1��30�� ����8:12:22 
 *
 */
public interface INoticeDao {
	/**
	 * 
	 * @Title: insert 
	 * @Description: �����ݿ�����ӹ���
	 * @param @param notice
	 * @param @throws SQLException  ����˵�� 
	 * @return void    �������� 
	 * @throws
	 */
	void insert(Notice notice) throws SQLException;
	
	/**
	 * 
	 * @Title: findAllNotice 
	 * @Description: �������ݿ��е����й��� 
	 * @param @throws SQLException  ����˵�� 
	 * @return void    �������� 
	 * @throws
	 */
	void findAllNotice() throws SQLException;
}
