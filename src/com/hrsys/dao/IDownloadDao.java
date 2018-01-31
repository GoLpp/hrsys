package com.hrsys.dao;
import java.sql.SQLException;
import java.util.List;
import com.hrsys.pojo.DownLoad;
/**
 * 
 * @ClassName: IDownloadDao 
 * @Description: �������ĵ����ݷ��ʲ�ӿ� 
 * @author GG Bone
 * @date 2018��1��31�� ����9:28:47 
 *
 */
public interface IDownloadDao {
	/**
	 * 
	 * @Title: findAllDownload 
	 * @Description: �������п�������Դ 
	 * @param @return
	 * @param @throws SQLException  ����˵�� 
	 * @return List<DownLoad>    �������� 
	 * @throws
	 */
	List<DownLoad> findAllDownload(String infor) throws SQLException;
	
	/**
	 * 
	 * @Title: removeDownload 
	 * @Description: �Ƴ��ϴ�����Դ
	 * @param @param infor
	 * @param @throws SQLException  ����˵�� 
	 * @return void    �������� 
	 * @throws
	 */
	void removeDownload(String infor) throws SQLException;
	
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
