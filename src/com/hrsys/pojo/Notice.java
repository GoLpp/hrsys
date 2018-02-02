package com.hrsys.pojo;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * @ClassName: Notice 
 * @Description: 描述公告的实体类
 * @author GG Bone
 * @date 2018年1月30日 下午7:00:49 
 *
 */
public class Notice implements Serializable{
	private Integer nId;         //公告id
	private String nName;        //公告主题
	private String nContent;     //公告内容
	private Date nCreateTime;  //公告创建时间
	private Integer uId;         //创建公告人的id
	private Integer nState;      //公告状态
	private User user;           //用户对象
	public Notice() {
		super();
		
	}
	public Notice(Integer nId, String nName, String nContent, Date nCreateTime, Integer uId, Integer nState,
			User user) {
		super();
		this.nId = nId;
		this.nName = nName;
		this.nContent = nContent;
		this.nCreateTime = nCreateTime;
		this.uId = uId;
		this.nState = nState;
		this.user = user;
	}
	public Integer getnId() {
		return nId;
	}
	public void setnId(Integer nId) {
		this.nId = nId;
	}
	public String getnName() {
		return nName;
	}
	public void setnName(String nName) {
		this.nName = nName;
	}
	public String getnContent() {
		return nContent;
	}
	public void setnContent(String nContent) {
		this.nContent = nContent;
	}
	public Date getnCreateTime() {
		return nCreateTime;
	}
	public void setnCreateTime(Date nCreateTime) {
		this.nCreateTime = nCreateTime;
	}
	public Integer getuId() {
		return uId;
	}
	public void setuId(Integer uId) {
		this.uId = uId;
	}
	public Integer getnState() {
		return nState;
	}
	public void setnState(Integer nState) {
		this.nState = nState;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Notice [nId=" + nId + ", nName=" + nName + ", nContent=" + nContent + ", nCreateTime=" + nCreateTime
				+ ", uId=" + uId + ", nState=" + nState + ", user=" + user + "]";
	}
}
