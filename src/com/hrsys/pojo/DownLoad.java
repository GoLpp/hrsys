package com.hrsys.pojo;

import java.io.Serializable;
import java.sql.Date;
/**
 * 
 * @ClassName: DownLoad 
 * @Description: 描述上传中心的实体类
 * @author GG Bone
 * @date 2018年1月30日 下午7:00:22 
 *
 */
public class DownLoad implements Serializable{
	private Integer doId;       //上传记录id
	private String doDescrip;   //上传文件描述
	private String doTitle;     //上传主题
	private Date doCreateTime;  //上传的时间
	private Integer uId;        //上传用户id
	private String url;         //上传保存的文件url
	private Integer downState;  //资源状态
	private User user;
	public DownLoad() {
		super();
	}
	public DownLoad(Integer doId, String doDescrip, String doTitle, Date doCreateTime, Integer uId, String url,
			Integer downState, User user) {
		super();
		this.doId = doId;
		this.doDescrip = doDescrip;
		this.doTitle = doTitle;
		this.doCreateTime = doCreateTime;
		this.uId = uId;
		this.url = url;
		this.downState = downState;
		this.user = user;
	}
	public Integer getDoId() {
		return doId;
	}
	public void setDoId(Integer doId) {
		this.doId = doId;
	}
	public String getDoDescrip() {
		return doDescrip;
	}
	public void setDoDescrip(String doDescrip) {
		this.doDescrip = doDescrip;
	}
	public String getDoTitle() {
		return doTitle;
	}
	public void setDoTitle(String doTitle) {
		this.doTitle = doTitle;
	}
	public Date getDoCreateTime() {
		return doCreateTime;
	}
	public void setDoCreateTime(Date doCreateTime) {
		this.doCreateTime = doCreateTime;
	}
	public Integer getuId() {
		return uId;
	}
	public void setuId(Integer uId) {
		this.uId = uId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getDownState() {
		return downState;
	}
	public void setDownState(Integer downState) {
		this.downState = downState;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "DownLoad [doId=" + doId + ", doDescrip=" + doDescrip + ", doTitle=" + doTitle + ", doCreateTime="
				+ doCreateTime + ", uId=" + uId + ", url=" + url + ", downState=" + downState + ", user=" + user + "]";
	}
	
}
