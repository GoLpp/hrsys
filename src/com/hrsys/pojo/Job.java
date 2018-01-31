package com.hrsys.pojo;

import java.io.Serializable;
/**
 * 
 * @ClassName: Job 
 * @Description: 描述职位的实体类
 * @author GG Bone
 * @date 2018年1月30日 下午6:44:13 
 *
 */
public class Job implements Serializable{
	private Integer jId;      //职位id
	private String jName;     //职位名字
	private String jDes;      //职位描述
	private String jState; //职位状态
	public Job() {
		super();
		
	}
	public Job(Integer jId, String jName, String jDes, String jState) {
		super();
		this.jId = jId;
		this.jName = jName;
		this.jDes = jDes;
		this.jState = jState;
	}
	public Integer getjId() {
		return jId;
	}
	public void setjId(Integer jId) {
		this.jId = jId;
	}
	public String getjName() {
		return jName;
	}
	public void setjName(String jName) {
		this.jName = jName;
	}
	public String getjDes() {
		return jDes;
	}
	public void setjDes(String jDes) {
		this.jDes = jDes;
	}
	public String getjState() {
		return jState;
	}
	public void setjState(String jState) {
		this.jState = jState;
	}
	@Override
	public String toString() {
		return "Job [jId=" + jId + ", jName=" + jName + ", jDes=" + jDes + ", jState=" + jState + "]";
	}
}
