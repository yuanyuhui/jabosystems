package com.ks.jabosystems.pojo;

public class Position {
	// `pid` INT(20) NOT NULL AUTO_INCREMENT COMMENT '职位ID',
	// `pname` VARCHAR(50) DEFAULT NULL COMMENT '职位名称',
	// `eid` VARCHAR(20) DEFAULT NULL COMMENT '员工ID',

	private Integer pid;
	private String pname;
	private String eid;

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public Position(Integer pid, String pname, String eid) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.eid = eid;
	}

	public Position() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Position [pid=" + pid + ", pname=" + pname + ", eid=" + eid + "]";
	}

}
