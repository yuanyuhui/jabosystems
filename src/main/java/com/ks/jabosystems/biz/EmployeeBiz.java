package com.ks.jabosystems.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ks.jabosystems.dao.IEmployeeDao;
import com.ks.jabosystems.pojo.Employee;
import com.ks.jabosystems.pojo.Position;

@Service()
public class EmployeeBiz {
	@Autowired
	private IEmployeeDao IEmployeeDao;

	@Autowired
	private com.ks.jabosystems.dao.IPositionDao IPositionDao;

	public Employee findEmployeeByenamewithepwd(Employee Employee) {
		return IEmployeeDao.queryByenamewithepwd(Employee);
	}

	public List<Employee> findEmployeeList() {
		return IEmployeeDao.queryList();
	}

	public Employee findEmployeeByeid(Employee Employee) {
		return IEmployeeDao.queryByeid(Employee);
	}

	public Employee findnextEmployeeByeid(Employee Employee) {
		Position Position = IPositionDao.queryByeid(Employee);
		Position position = IPositionDao.queryBynextPosition(Position.getPid() + 1);
		Employee e = new Employee(position.getEid());
		return IEmployeeDao.queryByeid(e);
	}
}
