package com.ks.jabosystems.action;

import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ks.jabosystems.biz.CheckresultBiz;
import com.ks.jabosystems.pojo.Checkresult;

@RestController
@RequestMapping("/Employee/api")
public class JabosystemsAjaxAction {
	@Autowired
	private CheckresultBiz CheckresultBiz;

	@RequestMapping(value = "/Voucher", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addVoucher(@RequestBody Checkresult Checkresult, HttpSession session) throws Exception {
		System.out.println(Checkresult);
		Checkresult.setTime(new Date());
		CheckresultBiz.addCheckresult(Checkresult);
		return null;
	}
}