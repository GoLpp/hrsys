package com.hrsys.pojo;

import java.io.Serializable;
import java.sql.Date;
/**
 * 
 * @ClassName: User 
 * @Description: �û�ʵ���� 
 * @author GG Bone
 * @date 2018��1��30�� ����6:37:22 
 *
 */
public class User implements Serializable{
	
	private Integer uId;            //�û�id
	private String uName;           //�û���
	private String uPwd;            //�û�����
	private String uLoginName;      //�û���¼��
	private int uState;             //�û�״̬
	private Date uCreateTime;       //�û���������
	
	public User() {
		super();
		
	}

	public User(Integer uId, String uName, String uPwd, String uLoginName, int uState, Date uCreateTime) {
		super();
		this.uId = uId;
		this.uName = uName;
		this.uPwd = uPwd;
		this.uLoginName = uLoginName;
		this.uState = uState;
		this.uCreateTime = uCreateTime;
	}

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuPwd() {
		return uPwd;
	}

	public void setuPwd(String uPwd) {
		this.uPwd = uPwd;
	}

	public String getuLoginName() {
		return uLoginName;
	}

	public void setuLoginName(String uLoginName) {
		this.uLoginName = uLoginName;
	}

	public int getuState() {
		return uState;
	}

	public void setuState(int uState) {
		this.uState = uState;
	}

	public Date getuCreateTime() {
		return uCreateTime;
	}

	public void setuCreateTime(Date uCreateTime) {
		this.uCreateTime = uCreateTime;
	}

	@Override
	public String toString() {
		return "User [uId=" + uId + ", uName=" + uName + ", uPwd=" + uPwd + ", uLoginName=" + uLoginName + ", uState="
				+ uState + ", uCreateTime=" + uCreateTime + "]";
	}
}
