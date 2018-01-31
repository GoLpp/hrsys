package com.hrsys.service;

import java.sql.SQLException;
import java.util.List;

import com.hrsys.pojo.DownLoad;

/**
 * 
 * @ClassName: IDownloadService 
 * @Description: ��������ҵ���߼���ӿ�
 * @author GG Bone
 * @date 2018��1��31�� ����6:51:37 
 *
 */
public interface IDownloadService {
	/**
	 * 
	 * @Title: findAllDownload 
	 * @Description: �������п�������Դ 
	 * @param @return
	 * @param @throws SQLException  ����˵�� 
	 * @return List<DownLoad>    �������� 
	 * @throws
	 */
	List<DownLoad> findAllDownload(DownLoad downLoad) throws SQLException;
	
	/**
	 * 
	 * @Title: findDownloadById 
	 * @Description: ͨ��id���� 
	 * @param @param downLoad
	 * @param @return
	 * @param @throws SQLException  ����˵�� 
	 * @return DownLoad    �������� 
	 * @throws
	 */
	DownLoad findDownloadById(DownLoad downLoad) throws SQLException;
	
	/**
	 * 
	 * @Title: findDownloadByCondition 
	 * @Description: ͨ���������� 
	 * @param @param downLoad
	 * @param @return
	 * @param @throws SQLException  ����˵�� 
	 * @return List<DownLoad>    �������� 
	 * @throws
	 */
	List<DownLoad> findDownloadByCondition(DownLoad downLoad) throws SQLException;
	/**
	 * 
	 * @Title: removeDownload 
	 * @Description: �Ƴ��ϴ�����Դ
	 * @param @param infor
	 * @param @throws SQLException  ����˵�� 
	 * @return void    �������� 
	 * @throws
	 */
	void removeDownload(DownLoad downLoad) throws SQLException;
	
	/**
	 * 
	 * @Title: updateDownload 
	 * @Description: �����ϴ������� 
	 * @param @param downLoad
	 * @param @throws SQLException  ����˵�� 
	 * @return void    �������� 
	 * @throws
	 */
	void updateDownload(DownLoad downLoad) throws SQLException;
	
	/**
	 * 
	 * @Title: insert 
	 * @Description: �ϴ������� 
	 * @param @param downLoad
	 * @param @throws SQLException  ����˵�� 
	 * @return void    �������� 
	 * @throws
	 */
	void insert(DownLoad downLoad) throws SQLException;

}