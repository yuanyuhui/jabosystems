package com.ks.jabosystems.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.ks.jabosystems.pojo.Employee;

public interface IEmployeeDao {
	public Employee queryByenamewithepwd(@Param("Employee") Employee Employee);

	public List<Employee> queryList();

	public Employee queryByeid(@Param("Employee") Employee Employee);
	
}
