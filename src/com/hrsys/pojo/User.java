package com.hrsys.pojo;

import java.io.Serializable;
import java.sql.Date;
/**
 * 
 * @ClassName: User 
 * @Description: 用户实体类 
 * @author GG Bone
 * @date 2018年1月30日 下午6:37:22 
 *
 */
public class User implements Serializable{
	
	private Integer uId;            //用户id
	private String uName;           //用户名
	private String uPwd;            //用户密码
	private String uLoginName;      //用户登录名
	private int uState;             //用户状态
	private Date uCreateTime;       //用户创建日期
	
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
