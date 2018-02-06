package com.hrsys.pojo;

import java.io.Serializable;
import java.sql.Date;
/**
 * 
 * @ClassName: DownLoad 
 * @Description: �����ϴ����ĵ�ʵ����
 * @author GG Bone
 * @date 2018��1��30�� ����7:00:22 
 *
 */
public class DownLoad implements Serializable{
	private Integer doId;       //�ϴ���¼id
	private String doDescrip;   //�ϴ��ļ�����
	private String doTitle;     //�ϴ�����
	private Date doCreateTime;  //�ϴ���ʱ��
	private Integer uId;        //�ϴ��û�id
	private String url;         //�ϴ�������ļ�url
	private Integer downState;  //��Դ״̬
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
