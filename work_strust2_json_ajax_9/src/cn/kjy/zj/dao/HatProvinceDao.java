package cn.kjy.zj.dao;

import java.util.List;

import cn.kjy.zj.pojo.HatCity;
import cn.kjy.zj.pojo.HatProvince;

public interface HatProvinceDao {
	/**
	 * 查询所有省份
	 * @return
	 */
	public List<HatProvince> findAll();
	/**
	 * 根据主键查询所有的城市
	 * @return
	 */
	public List<HatCity> findHatCilyByProvinceId(String provinceId);
}
