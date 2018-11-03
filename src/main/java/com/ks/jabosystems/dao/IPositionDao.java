package com.ks.jabosystems.dao;

import org.apache.ibatis.annotations.Param;
import com.ks.jabosystems.pojo.Checkresult;
import com.ks.jabosystems.pojo.Employee;
import com.ks.jabosystems.pojo.Position;

public interface IPositionDao {
	public Position queryBynexteid(@Param("Checkresult") Checkresult Checkresult);
	
	public Position queryByeid(@Param("Employee") Employee Employee);
	
	public Position queryBynextPosition(Integer pid);
}
