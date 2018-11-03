package com.ks.jabosystems.biz;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ks.jabosystems.dao.ICheckresultDao;
import com.ks.jabosystems.dao.IPositionDao;
import com.ks.jabosystems.pojo.Checkresult;
import com.ks.jabosystems.pojo.Position;

@Service()
public class CheckresultBiz {
	@Autowired
	private ICheckresultDao ICheckresultDao;

	@Autowired
	private IPositionDao IPositionDao;
	
	public List<Checkresult> findCheckresultByvc_id(String vc_id) {
		return ICheckresultDao.queryByvc_id(vc_id);
	}

	public void addCheckresult(Checkresult Checkresult) {
		Position Position = IPositionDao.queryBynexteid(Checkresult);
		int pid = Position.getPid();
		if (pid < 4) {
			pid++;
		}
		if(pid==4&&Checkresult.getStatus().equals("财务打款成功")) {
			pid=0;
		}
		Checkresult.setNext_eid("00" + pid);
		ICheckresultDao.insertCheckresult(Checkresult);
	}
}
