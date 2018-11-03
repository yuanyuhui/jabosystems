package com.ks.jabosystems.vo;

import java.util.ArrayList;
import java.util.List;
import com.ks.jabosystems.pojo.Employee;
import com.ks.jabosystems.pojo.Voucher;

public class BxVo {
	// 多个员工 对应一个职位 对应一个部门, 对应一个报销单 ,对应多个审核表,对应多个报销详情单
	private List<Employee> Employee=new ArrayList<Employee>(0);
	private List<Voucher> Voucher=new ArrayList<Voucher>(0);
	public List<Employee> getEmployee() {
		return Employee;
	}
	public void setEmployee(List<Employee> employee) {
		Employee = employee;
	}
	public List<Voucher> getVoucher() {
		return Voucher;
	}
	public void setVoucher(List<Voucher> voucher) {
		Voucher = voucher;
	}
	public BxVo(List<com.ks.jabosystems.pojo.Employee> employee, List<com.ks.jabosystems.pojo.Voucher> voucher) {
		super();
		Employee = employee;
		Voucher = voucher;
	}
	public BxVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BxVo [Employee=" + Employee + ", Voucher=" + Voucher + "]";
	}


}
