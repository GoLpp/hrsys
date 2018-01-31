package com.hrsys.pojo;

import java.io.Serializable;
import java.sql.Date;
/**
 * 
 * @ClassName: Employee 
 * @Description: 描述员工的实体类
 * @author GG Bone
 * @date 2018年1月30日 下午6:48:45 
 *
 */
public class Employee implements Serializable{
	private Integer eId;      //员工id
	private String eName;	  //员工姓名
	private Integer eGender;  //员工性别
	private String eTelNum;   //员工手机号码
	private String eEmail;    //员工邮箱地址
	private String jId;       //职位id
	private String eStu;      //学历
	private Integer dId;      //所属部门id
	private String eIdCard;   //员工身份证号码
	private Date eCreateTime; //员工创建日期
	private String eAddress;  //员工家庭住址
	private Integer eState;
	public Employee() {
		super();
		
	}
	public Employee(Integer eId, String eName, Integer eGender, String eTelNum, String eEmail, String jId, String eStu,
			Integer dId, String eIdCard, Date eCreateTime, String eAddress, Integer eState) {
		super();
		this.eId = eId;
		this.eName = eName;
		this.eGender = eGender;
		this.eTelNum = eTelNum;
		this.eEmail = eEmail;
		this.jId = jId;
		this.eStu = eStu;
		this.dId = dId;
		this.eIdCard = eIdCard;
		this.eCreateTime = eCreateTime;
		this.eAddress = eAddress;
		this.eState = eState;
	}
	public Integer geteId() {
		return eId;
	}
	public void seteId(Integer eId) {
		this.eId = eId;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public Integer geteGender() {
		return eGender;
	}
	public void seteGender(Integer eGender) {
		this.eGender = eGender;
	}
	public String geteTelNum() {
		return eTelNum;
	}
	public void seteTelNum(String eTelNum) {
		this.eTelNum = eTelNum;
	}
	public String geteEmail() {
		return eEmail;
	}
	public void seteEmail(String eEmail) {
		this.eEmail = eEmail;
	}
	public String getjId() {
		return jId;
	}
	public void setjId(String jId) {
		this.jId = jId;
	}
	public String geteStu() {
		return eStu;
	}
	public void seteStu(String eStu) {
		this.eStu = eStu;
	}
	public Integer getdId() {
		return dId;
	}
	public void setdId(Integer dId) {
		this.dId = dId;
	}
	public String geteIdCard() {
		return eIdCard;
	}
	public void seteIdCard(String eIdCard) {
		this.eIdCard = eIdCard;
	}
	public Date geteCreateTime() {
		return eCreateTime;
	}
	public void seteCreateTime(Date eCreateTime) {
		this.eCreateTime = eCreateTime;
	}
	public String geteAddress() {
		return eAddress;
	}
	public void seteAddress(String eAddress) {
		this.eAddress = eAddress;
	}
	
	public Integer geteState() {
		return eState;
	}
	public void seteState(Integer eState) {
		this.eState = eState;
	}
	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", eName=" + eName + ", eGender=" + eGender + ", eTelNum=" + eTelNum
				+ ", eEmail=" + eEmail + ", jId=" + jId + ", eStu=" + eStu + ", dId=" + dId + ", eIdCard=" + eIdCard
				+ ", eCreateTime=" + eCreateTime + ", eAddress=" + eAddress + ", eState=" + eState + "]";
	}
}
