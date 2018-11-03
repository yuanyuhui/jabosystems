package com.ks.jabosystems.action;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.github.pagehelper.PageInfo;
import com.ks.jabosystems.biz.BxVoBiz;
import com.ks.jabosystems.biz.CheckresultBiz;
import com.ks.jabosystems.biz.EmployeeBiz;
import com.ks.jabosystems.pojo.Checkresult;
import com.ks.jabosystems.pojo.Employee;
import com.ks.jabosystems.pojo.Voucher;
import com.ks.jabosystems.vo.BxVo;

@Controller
@RequestMapping("/Employee")
public class JabosystemsJSPAction {
	@Autowired
	private EmployeeBiz EmployeeBiz;

	@Autowired
	private BxVoBiz BxVoBiz;

	@Autowired
	private CheckresultBiz CheckresultBiz;

	@RequestMapping(value = "/loginin", method = RequestMethod.GET)
	public String loginin(HttpSession session, Employee Employee, Model model) throws Exception {
		Employee Employee1 = EmployeeBiz.findEmployeeByenamewithepwd(Employee);
		if (Employee1 != null) {
			/*
			 * // 增加在线人数 ServletContext application = session.getServletContext(); Integer
			 * userCount = (Integer) application.getAttribute("USER_COUNT"); userCount++;
			 * application.setAttribute("USER_COUNT", userCount);
			 */
			session.setAttribute("Employee", Employee1);
			return "redirect:/Employee/bxlist?pageNum=1&pageSize=3";
		} else {
			model.addAttribute("MSG", "工号或密码错误");
			return "/login.jsp";
		}
	}

	@RequestMapping(value = "/bxlist", method = RequestMethod.GET)
	public String bxlist(HttpSession session, Model model, Integer pageNum, Integer pageSize) throws Exception {
		Employee Employee = (com.ks.jabosystems.pojo.Employee) session.getAttribute("Employee");
		PageInfo<BxVo> data = BxVoBiz.findBxvoByeid(Employee, pageNum, pageSize);
		model.addAttribute("data", data);
		session.setAttribute("data", data);
		List<Employee> list = EmployeeBiz.findEmployeeList();
		model.addAttribute("list", list);
		model.addAttribute("Employee", Employee);
		return "/bxlist.jsp";
	}

	@RequestMapping(value = "/bxdetails", method = RequestMethod.GET)
	public String bxdetails(HttpSession session, Model model, String create_eid, String vc_id) throws Exception {
		PageInfo<BxVo> data = (PageInfo<BxVo>) session.getAttribute("data");
		Employee Employee = (com.ks.jabosystems.pojo.Employee) session.getAttribute("Employee");

		BxVo bxVo = new BxVo();
		for (BxVo d : data.getList()) {
			for (Employee e : d.getEmployee()) {
				if (e.getEid().equals(create_eid)) {
					bxVo.setEmployee(d.getEmployee());
				}
			}
			for (Voucher v : d.getVoucher()) {
				if (v.getVc_id().equals(vc_id)) {
					bxVo.setVoucher(d.getVoucher());
				}
			}
		}
		model.addAttribute("bxVo", bxVo);
		List<Employee> list_Employee = EmployeeBiz.findEmployeeList();
		model.addAttribute("list_Employee", list_Employee);
		List<Checkresult> list_checkresult = CheckresultBiz.findCheckresultByvc_id(vc_id);
		model.addAttribute("list_checkresult", list_checkresult);
		model.addAttribute("Employee", Employee);
		return "/bxdetails.jsp";
	}

	@RequestMapping(value = "/bxexamination", method = RequestMethod.GET)
	public String bxexamination(HttpSession session, Model model, String create_eid, String vc_id) throws Exception {
		PageInfo<BxVo> data = (PageInfo<BxVo>) session.getAttribute("data");
		BxVo bxVo = new BxVo();
		for (BxVo d : data.getList()) {
			for (Employee e : d.getEmployee()) {
				if (e.getEid().equals(create_eid)) {
					bxVo.setEmployee(d.getEmployee());
				}
			}
			for (Voucher v : d.getVoucher()) {
				if (v.getVc_id().equals(vc_id)) {
					bxVo.setVoucher(d.getVoucher());
				}
			}
		}
		model.addAttribute("bxVo", bxVo);
		Employee Employee = (com.ks.jabosystems.pojo.Employee) session.getAttribute("Employee");
		model.addAttribute("eidd", Employee.getEid());
		List<Employee> list = EmployeeBiz.findEmployeeList();
		model.addAttribute("list", list);
		List<Checkresult> list_checkresult = CheckresultBiz.findCheckresultByvc_id(vc_id);
		model.addAttribute("list_checkresult", list_checkresult);
		model.addAttribute("Employee", Employee);
		return "/bxexamination.jsp";
	}

	@RequestMapping(value = "/bxadd", method = RequestMethod.GET)
	public String bxadd(HttpSession session, Model model) throws Exception {
		Employee Employee = (com.ks.jabosystems.pojo.Employee) session.getAttribute("Employee");
		Employee Employee1 = EmployeeBiz.findEmployeeByeid(Employee);
		Employee Employee2 = EmployeeBiz.findnextEmployeeByeid(Employee1);
		model.addAttribute("Employee1", Employee1);
		model.addAttribute("Employee2", Employee2);
		model.addAttribute("Employee", Employee);
		Date date=new Date();
		model.addAttribute("date", date);
		return "/bxadd.jsp";
	}
}
