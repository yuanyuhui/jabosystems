package com.ks.jabosystems.pojo;

public class Voucher_detail {
	// `vcd_id` INT(30) NOT NULL AUTO_INCREMENT COMMENT '报销详情ID',
	// `vc_id` INT(30) DEFAULT NULL COMMENT '报销ID',
	// `item` VARCHAR(50) DEFAULT NULL COMMENT '报销类型',
	// `account` DOUBLE DEFAULT NULL COMMENT '报销金额',
	// `explain` VARCHAR(50) DEFAULT NULL COMMENT '对应报销类型的说明',
	// `vd_path` VARCHAR(200) DEFAULT NULL COMMENT '收据的存放路径',
	private Integer vcd_id;
	private Integer vc_id;
	private String item;
	private Double account;
	private String explain;
	private String vd_path;

	public Integer getVcd_id() {
		return vcd_id;
	}

	public void setVcd_id(Integer vcd_id) {
		this.vcd_id = vcd_id;
	}

	public Integer getVc_id() {
		return vc_id;
	}

	public void setVc_id(Integer vc_id) {
		this.vc_id = vc_id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Double getAccount() {
		return account;
	}

	public void setAccount(Double account) {
		this.account = account;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	public String getVd_path() {
		return vd_path;
	}

	public void setVd_path(String vd_path) {
		this.vd_path = vd_path;
	}

	public Voucher_detail(Integer vcd_id, Integer vc_id, String item, Double account, String explain, String vd_path) {
		super();
		this.vcd_id = vcd_id;
		this.vc_id = vc_id;
		this.item = item;
		this.account = account;
		this.explain = explain;
		this.vd_path = vd_path;
	}

	public Voucher_detail() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Voucher_detail [vcd_id=" + vcd_id + ", vc_id=" + vc_id + ", item=" + item + ", account=" + account
				+ ", explain=" + explain + ", vd_path=" + vd_path + "]";
	}

}
