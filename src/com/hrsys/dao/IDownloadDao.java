package com.hrsys.dao;
import java.sql.SQLException;
import java.util.List;
import com.hrsys.pojo.DownLoad;
/**
 * 
 * @ClassName: IDownloadDao 
 * @Description: 下载中心的数据访问层接口 
 * @author GG Bone
 * @date 2018年1月31日 上午9:28:47 
 *
 */
public interface IDownloadDao {
	/**
	 * 
	 * @Title: findAllDownload 
	 * @Description: 查找所有可下载资源 
	 * @param @return
	 * @param @throws SQLException  参数说明 
	 * @return List<DownLoad>    返回类型 
	 * @throws
	 */
	List<DownLoad> findAllDownload(DownLoad downLoad) throws SQLException;
	
	/**
	 * 
	 * @Title: findDownloadById 
	 * @Description: 通过id查找 
	 * @param @param downLoad
	 * @param @return
	 * @param @throws SQLException  参数说明 
	 * @return DownLoad    返回类型 
	 * @throws
	 */
	DownLoad findDownloadById(DownLoad downLoad) throws SQLException;
	
	/**
	 * 
	 * @Title: findDownloadByCondition 
	 * @Description: 通过条件查找 
	 * @param @param downLoad
	 * @param @return
	 * @param @throws SQLException  参数说明 
	 * @return List<DownLoad>    返回类型 
	 * @throws
	 */
	List<DownLoad> findDownloadByCondition(DownLoad downLoad) throws SQLException;
	/**
	 * 
	 * @Title: removeDownload 
	 * @Description: 移除上传的资源
	 * @param @param infor
	 * @param @throws SQLException  参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	void removeDownload(DownLoad downLoad) throws SQLException;
	
	/**
	 * 
	 * @Title: updateDownload 
	 * @Description: 更新上传的数据 
	 * @param @param downLoad
	 * @param @throws SQLException  参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	void updateDownload(DownLoad downLoad) throws SQLException;
	
	/**
	 * 
	 * @Title: insert 
	 * @Description: 上传新数据 
	 * @param @param downLoad
	 * @param @throws SQLException  参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	void insert(DownLoad downLoad) throws SQLException;
}
