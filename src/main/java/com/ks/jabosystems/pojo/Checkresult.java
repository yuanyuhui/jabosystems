package com.ks.jabosystems.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Checkresult {
	// `cr_id` INT(50) NOT NULL AUTO_INCREMENT COMMENT '审核id',
	// `vc_id` VARCHAR(200) DEFAULT NULL COMMENT '报销ID引用',
	// `leave_id` VARCHAR(200) DEFAULT NULL COMMENT '请假ID引用',
	// `create_eid` VARCHAR(20) DEFAULT NULL COMMENT '创建人员ID',
	// `next_eid` VARCHAR(20) DEFAULT NULL COMMENT '待处理人员id',
	// `time` DATE DEFAULT NULL COMMENT '审核的时间',
	// `status` VARCHAR(20) DEFAULT NULL COMMENT '审核状态标注',
	// `check_comment` VARCHAR(200) DEFAULT NULL COMMENT '审核意见',
	private Integer cr_id;
	private String vc_id;
	private String leave_id;
	private String create_eid;
	private String next_eid;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date time;
	private String status;
	private String check_comment;

	public Integer getCr_id() {
		return cr_id;
	}

	public void setCr_id(Integer cr_id) {
		this.cr_id = cr_id;
	}

	public String getVc_id() {
		return vc_id;
	}

	public void setVc_id(String vc_id) {
		this.vc_id = vc_id;
	}

	public String getLeave_id() {
		return leave_id;
	}

	public void setLeave_id(String leave_id) {
		this.leave_id = leave_id;
	}

	public String getCreate_eid() {
		return create_eid;
	}

	public void setCreate_eid(String create_eid) {
		this.create_eid = create_eid;
	}

	public String getNext_eid() {
		return next_eid;
	}

	public void setNext_eid(String next_eid) {
		this.next_eid = next_eid;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCheck_comment() {
		return check_comment;
	}

	public void setCheck_comment(String check_comment) {
		this.check_comment = check_comment;
	}

	public Checkresult(Integer cr_id, String vc_id, String leave_id, String create_eid, String next_eid, Date time,
			String status, String check_comment) {
		super();
		this.cr_id = cr_id;
		this.vc_id = vc_id;
		this.leave_id = leave_id;
		this.create_eid = create_eid;
		this.next_eid = next_eid;
		this.time = time;
		this.status = status;
		this.check_comment = check_comment;
	}

	public Checkresult() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Checkresult [cr_id=" + cr_id + ", vc_id=" + vc_id + ", leave_id=" + leave_id + ", create_eid="
				+ create_eid + ", next_eid=" + next_eid + ", time=" + time + ", status=" + status + ", check_comment="
				+ check_comment + "]";
	}

}
