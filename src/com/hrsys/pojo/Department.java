package com.hrsys.pojo;

import java.io.Serializable;
/**
 * 
 * @ClassName: Department 
 * @Description: ����ʵ����
 * @author GG Bone
 * @date 2018��1��30�� ����6:40:47 
 *
 */
public class Department implements Serializable{
	
	private Integer dId;     //����id
	private String dName;   //������
	private String dDes;    //��������
	private Integer dState; //����״̬
	public Department() {
		super();
		
	}
	public Department(Integer dId, String dName, String dDes, Integer dState) {
		super();
		this.dId = dId;
		this.dName = dName;
		this.dDes = dDes;
		this.dState = dState;
	}
	public Integer getdId() {
		return dId;
	}
	public void setdId(Integer dId) {
		this.dId = dId;
	}
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	public String getdDes() {
		return dDes;
	}
	public void setdDes(String dDes) {
		this.dDes = dDes;
	}
	public Integer getdState() {
		return dState;
	}
	public void setdState(Integer dState) {
		this.dState = dState;
	}
	@Override
	public String toString() {
		return "Department [dId=" + dId + ", dName=" + dName + ", dDes=" + dDes + ", dState=" + dState + "]";
	}
}
