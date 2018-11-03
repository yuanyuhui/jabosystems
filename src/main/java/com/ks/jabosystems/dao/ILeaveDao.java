package com.ks.jabosystems.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ks.jabosystems.pojo.Employee;
import com.ks.jabosystems.pojo.Leave;

/**
 * 请假Dao层
 * 
 * @author yuanyuhui
 *
 */
public interface ILeaveDao {
	/**
	 * 根据登陆的用户,查询所有的请假数据(自己的和所管人的)
	 * 
	 * @return
	 */
	public List<Leave> queryList(@Param("Employee") Employee Employee);
}
