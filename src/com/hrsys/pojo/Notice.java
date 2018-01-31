package com.hrsys.pojo;

import java.io.Serializable;
/**
 * 
 * @ClassName: Notice 
 * @Description: 描述公告的实体类
 * @author GG Bone
 * @date 2018年1月30日 下午7:00:49 
 *
 */
public class Notice implements Serializable{
	private Integer nId;         //公告id
	private String nName;        //公告主题
	private String nContent;     //公告内容
	private String nCreateTime;  //公告创建时间
	private Integer uId;         //创建公告人的id
	private Integer nState;      //公告状态
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
