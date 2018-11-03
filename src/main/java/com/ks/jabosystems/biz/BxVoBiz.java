package com.ks.jabosystems.biz;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ks.jabosystems.dao.IBxVoGRDao;
import com.ks.jabosystems.pojo.Employee;
import com.ks.jabosystems.vo.BxVo;

@Service()
public class BxVoBiz {
	@Autowired
	private IBxVoGRDao IBxVoGRDao;

	@Autowired
	private com.ks.jabosystems.dao.IBxVoQXDao IBxVoQXDao;

	public PageInfo<BxVo> findBxvoByeid(Employee Employee, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<BxVo> data = new ArrayList<BxVo>();
		//查自己的报销
		List<BxVo> data1 = IBxVoGRDao.queryByeidBxVo(Employee);
		//查权限的报销
		List<BxVo> data2 = IBxVoQXDao.queryByeidBxVo(Employee);
		for (BxVo bxVo1 : data1) {
			data.add(bxVo1);
		}
		for (BxVo bxVo2 : data2) {
			data.add(bxVo2);
		}
		return new PageInfo<BxVo>(data);
	}
}
