package com.ks.jabosystems.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class Voucher {
	// `vc_id` INT(50) NOT NULL AUTO_INCREMENT COMMENT '报销ID',
	// `create_eid` VARCHAR(20) DEFAULT NULL COMMENT '发起的人员ID',
	// `next_eid` VARCHAR(20) DEFAULT NULL COMMENT '待处理人员ID',
	// `create_time` DATETIME DEFAULT NULL COMMENT '发起的时间',
	// `total_account` DOUBLE DEFAULT NULL COMMENT '报销的总金额',
	// `event` VARCHAR(300) DEFAULT NULL COMMENT '事由说明',

	// 对应一个报销单 ,对应多个审核表,对应多个报销详情单
	private String vc_id;
	private String create_eid;
	private String next_eid;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date create_time;
	private Double total_account;
	private String event;
	private List<Checkresult> Checkresult = new ArrayList<Checkresult>(0);
	private List<Voucher_detail> Voucher_detail = new ArrayList<Voucher_detail>(0);

	public String getVc_id() {
		return vc_id;
	}

	public void setVc_id(String vc_id) {
		this.vc_id = vc_id;
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

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Double getTotal_account() {
		return total_account;
	}

	public void setTotal_account(Double total_account) {
		this.total_account = total_account;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public List<Checkresult> getCheckresult() {
		return Checkresult;
	}

	public void setCheckresult(List<Checkresult> checkresult) {
		Checkresult = checkresult;
	}

	public List<Voucher_detail> getVoucher_detail() {
		return Voucher_detail;
	}

	public void setVoucher_detail(List<Voucher_detail> voucher_detail) {
		Voucher_detail = voucher_detail;
	}

	public Voucher(String vc_id, String create_eid, String next_eid, Date create_time, Double total_account,
			String event, List<com.ks.jabosystems.pojo.Checkresult> checkresult,
			List<com.ks.jabosystems.pojo.Voucher_detail> voucher_detail) {
		super();
		this.vc_id = vc_id;
		this.create_eid = create_eid;
		this.next_eid = next_eid;
		this.create_time = create_time;
		this.total_account = total_account;
		this.event = event;
		Checkresult = checkresult;
		Voucher_detail = voucher_detail;
	}

	public Voucher() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Voucher [vc_id=" + vc_id + ", create_eid=" + create_eid + ", next_eid=" + next_eid + ", create_time="
				+ create_time + ", total_account=" + total_account + ", event=" + event + ", Checkresult=" + Checkresult
				+ ", Voucher_detail=" + Voucher_detail + "]";
	}

}
