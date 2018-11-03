package com.ks.jabosystems.pojo;

public class Department {
	// `pid` INT(10) NOT NULL AUTO_INCREMENT COMMENT '部门ID',
	// `pname` VARCHAR(50) DEFAULT NULL COMMENT '部门名称',
	// `eid` VARCHAR(20) DEFAULT NULL COMMENT '员工ID',
	// `manager_eid` VARCHAR(50) DEFAULT NULL COMMENT '对应的部门经理ID，部门经理则为0',

	private Integer did;
	private String dname;
	private String eid;
	private String manager_eid;

	public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getManager_eid() {
		return manager_eid;
	}

	public void setManager_eid(String manager_eid) {
		this.manager_eid = manager_eid;
	}

	public Department(Integer did, String dname, String eid, String manager_eid) {
		super();
		this.did = did;
		this.dname = dname;
		this.eid = eid;
		this.manager_eid = manager_eid;
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Department [did=" + did + ", dname=" + dname + ", eid=" + eid + ", manager_eid=" + manager_eid + "]";
	}

}
