package com.hrsys.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.hrsys.dao.INoticeDao;
import com.hrsys.exception.NoticeServiceException;
import com.hrsys.pojo.Notice;
import com.hrsys.service.INoticeService;
import com.hrsys.utils.ObjectUtils;

public class NoticeService implements INoticeService{

	private INoticeDao noticeDao = null;
	public NoticeService() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		noticeDao = ObjectUtils.getObject("noticeDao");
	}
	@Override
	public void insert(Notice notice) throws SQLException {
		if(notice.getnContent().equals("") || notice.getnCreateTime() == null
				|| notice.getnName().equals("")
				|| notice.getuId() == null) {
			throw new NoticeServiceException("输入参数错误");
		}
		noticeDao.insert(notice);
	}

	@Override
	public List<Notice> findAllNotice() throws SQLException {
		return noticeDao.findAllNotice();
	}

	@Override
	public List<Notice> findNoticeByCondition(Notice notice) throws SQLException {
		return noticeDao.findNoticeByCondition(notice);
	}

	@Override
	public Notice findNoticeById(Notice notice) throws SQLException {
		if(null == notice.getnId()) {
			throw new NoticeServiceException("输入参数错误");
		}
		return noticeDao.findNoticeById(notice);
	}

	@Override
	public void removeNotice(Notice notice) throws SQLException {
		if(null == notice.getnId()) {
			throw new NoticeServiceException("输入参数错误");
		}
		noticeDao.removeNotice(notice);
	}

	@Override
	public void updateNotice(Notice notice) throws SQLException {
		if(notice.getnContent().equals("") || notice.getnCreateTime() == null
				|| notice.getnName().equals("")
				|| notice.getuId() == null) {
			throw new NoticeServiceException("输入参数错误");
		}
		noticeDao.updateNotice(notice);
	}

}
