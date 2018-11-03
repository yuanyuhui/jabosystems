package com.ks.jabosystems.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ks.jabosystems.pojo.Employee;
import com.ks.jabosystems.vo.BxVo;

public interface IBxVoQXDao {
	public List<BxVo> queryByeidBxVo(@Param("Employee") Employee Employee);
}
