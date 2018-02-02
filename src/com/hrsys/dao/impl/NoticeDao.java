package com.hrsys.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.hrsys.dao.INoticeDao;
import com.hrsys.pojo.Notice;
import com.hrsys.utils.JdbcUtils;
/**
 * 
 * @ClassName: NoticeDao 
 * @Description: 公告数据访问实现类
 * @author GG Bone
 * @date 2018年1月31日 上午9:57:16 
 *
 */
public class NoticeDao implements INoticeDao{

	@Override
	public void insert(Notice notice) throws SQLException {
		String sql = "insert into t_notice(nName,nContent,nCreateTime,uId) "
				+ "values(?,?,?,?)";
		JdbcUtils.getQueryRunner().update(sql, notice.getnName(),
				notice.getnContent(),new Date(),
				notice.getuId());
		
	}

	@Override
	public List<Notice> findAllNotice() throws SQLException {
		String sql = "select *from t_notice where nState=1";
		return JdbcUtils.getQueryRunner().query(sql, new BeanListHandler<>(Notice.class));
	}

	@Override
	public void removeNotice(Notice notice) throws SQLException {
		String sql = "update t_notice set nState=0 where nId=?";
		JdbcUtils.getQueryRunner().update(sql, notice.getnId());
	}

	@Override
	public void updateNotice(Notice notice) throws SQLException {
		String sql = "update t_notice set nName=?,nContent=?,nCreateTime=?"
				+ " where nId=?";
		JdbcUtils.getQueryRunner().update(sql,notice.getnName(),notice.getnContent(),
				new Date(),notice.getnId());
	}

	@Override
	public List<Notice> findNoticeByCondition(Notice notice) throws SQLException {
		StringBuilder sql = new StringBuilder("select *from t_notice where 1=1 and nState=1");
		if(notice.getnName()!=null && !notice.getnName().equals("")) {
			sql.append(" and nName like '%"+notice.getnName()+"%'");
		}
		if(notice.getnContent()!=null && !notice.getnContent().equals("")) {
			sql.append(" and nContent like '%"+notice.getnContent()+"%'");
		}
		return JdbcUtils.getQueryRunner().query(sql.toString(), new BeanListHandler<>(Notice.class));
	}

	@Override
	public Notice findNoticeById(Notice notice) throws SQLException {
		String sql = "select *from t_notice where nId=? and nState=1";
		return JdbcUtils.getQueryRunner().query(sql, new BeanHandler<>(Notice.class),notice.getnId());
	}

}
