package com.ks.jabosystems.pojo;

/**
 * 员工表
 * 
 * @author yuanyuhui
 *
 */
public class Employee {

	// `eid` VARCHAR(20) NOT NULL COMMENT '员工ID',
	// `ename` VARCHAR(50) DEFAULT NULL COMMENT '员工姓名',
	// `epwd` VARCHAR(50) DEFAULT NULL COMMENT '员工密码',
	// `position_id` INT(20) DEFAULT NULL COMMENT '员工职位id',
	// `department_id` INT(20) DEFAULT NULL COMMENT '部门id',
	// `status` INT(20) DEFAULT NULL COMMENT '上下级关系编码',
	private String eid;// 员工ID
	private String ename;// 员工姓名
	private String epwd;// 员工密码
	private Integer position_id;// 员工职位id
	private Integer department_id;// 部门id
	private Integer status;// 上下级关系编码
	private Position Position;//职位表
	private Department Department;//部门表

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEpwd() {
		return epwd;
	}

	public void setEpwd(String epwd) {
		this.epwd = epwd;
	}

	public Integer getPosition_id() {
		return position_id;
	}

	public void setPosition_id(Integer position_id) {
		this.position_id = position_id;
	}

	public Integer getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(Integer department_id) {
		this.department_id = department_id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Position getPosition() {
		return Position;
	}

	public void setPosition(Position position) {
		Position = position;
	}

	public Department getDepartment() {
		return Department;
	}

	public void setDepartment(Department department) {
		Department = department;
	}

	public Employee(String eid, String ename, String epwd, Integer position_id, Integer department_id, Integer status,
			com.ks.jabosystems.pojo.Position position, com.ks.jabosystems.pojo.Department department) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.epwd = epwd;
		this.position_id = position_id;
		this.department_id = department_id;
		this.status = status;
		Position = position;
		Department = department;
	}
	
	public Employee(String eid) {
		super();
		this.eid = eid;
	}

	public Employee(String eid, String ename, String epwd, Integer position_id, Integer department_id, Integer status) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.epwd = epwd;
		this.position_id = position_id;
		this.department_id = department_id;
		this.status = status;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", epwd=" + epwd + ", position_id=" + position_id
				+ ", department_id=" + department_id + ", status=" + status + ", Position=" + Position + ", Department="
				+ Department + "]";
	}

}
