package com.hrsys.pojo;

import java.io.Serializable;
/**
 * 
 * @ClassName: Department 
 * @Description: 部门实体类
 * @author GG Bone
 * @date 2018年1月30日 下午6:40:47 
 *
 */
public class Department implements Serializable{
	
	private Integer dId;  //部门id
	private String dName; //部门名
	private String dDes;  //部门描述
	public Department() {
		super();
		
	}
	public Department(Integer dId, String dName, String dDes) {
		super();
		this.dId = dId;
		this.dName = dName;
		this.dDes = dDes;
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
	@Override
	public String toString() {
		return "Department [dId=" + dId + ", dName=" + dName + ", dDes=" + dDes + "]";
	}
}
