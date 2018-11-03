package com.ks.jabosystems.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ks.jabosystems.pojo.Checkresult;

public interface ICheckresultDao {
	public List<Checkresult> queryByvc_id(String vc_id);

	public void insertCheckresult(@Param("Checkresult") Checkresult Checkresult);
}
