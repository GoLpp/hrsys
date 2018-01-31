package com.hrsys.pojo;

import java.io.Serializable;
import java.sql.Date;
/**
 * 
 * @ClassName: Employee 
 * @Description: ����Ա����ʵ����
 * @author GG Bone
 * @date 2018��1��30�� ����6:48:45 
 *
 */
public class Employee implements Serializable{
	private Integer eId;      //Ա��id
	private String eName;	  //Ա������
	private Integer eGender;  //Ա���Ա�
	private String eTelNum;   //Ա���ֻ�����
	private String eEmail;    //Ա�������ַ
	private String jId;       //ְλid
	private String eStu;      //ѧ��
	private Integer dId;      //��������id
	private String eIdCard;   //Ա�����֤����
	private Date eCreateTime; //Ա����������
	private String eAddress;  //Ա����ͥסַ
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
