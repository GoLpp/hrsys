package com.hrsys.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.hrsys.dao.INoticeDao;
import com.hrsys.pojo.Notice;
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
		
	}

	@Override
	public List<Notice> findAllNotice() throws SQLException {
		return null;
	}

	@Override
	public List<Notice> findNoticeByLikeTile(Notice notice) throws SQLException {
		return null;
	}

	@Override
	public List<Notice> findNoticeByLikeContent(Notice notice) throws SQLException {
		return null;
	}

	@Override
	public void removeNotice(Notice notice) throws SQLException {
		
	}

	@Override
	public void updateNotice(Notice notice) throws SQLException {
		
	}

}
