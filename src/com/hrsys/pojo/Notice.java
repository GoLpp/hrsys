package com.hrsys.pojo;

import java.io.Serializable;
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
	private String nCreateTime;  //���洴��ʱ��
	private Integer uId;         //���������˵�id
	private Integer nState;      //����״̬
	public Notice() {
		super();
		
	}
	public Notice(Integer nId, String nName, String nContent, String nCreateTime, Integer uId, Integer nState) {
		super();
		this.nId = nId;
		this.nName = nName;
		this.nContent = nContent;
		this.nCreateTime = nCreateTime;
		this.uId = uId;
		this.nState = nState;
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
	public String getnCreateTime() {
		return nCreateTime;
	}
	public void setnCreateTime(String nCreateTime) {
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
	@Override
	public String toString() {
		return "Notice [nId=" + nId + ", nName=" + nName + ", nContent=" + nContent + ", nCreateTime=" + nCreateTime
				+ ", uId=" + uId + ", nState=" + nState + "]";
	}
}
