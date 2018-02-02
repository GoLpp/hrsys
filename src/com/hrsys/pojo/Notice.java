package com.hrsys.pojo;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * @ClassName: Notice 
 * @Description: ���������ʵ����
 * @author GG Bone
 * @date 2018��1��30�� ����7:00:49 
 *
 */
public class Notice implements Serializable{
	private Integer nId;         //����id
	private String nName;        //��������
	private String nContent;     //��������
	private Date nCreateTime;  //���洴��ʱ��
	private Integer uId;         //���������˵�id
	private Integer nState;      //����״̬
	private User user;           //�û�����
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
