package cn.kjy.zj.dao;

import java.util.List;

import cn.kjy.zj.pojo.HatArea;
import cn.kjy.zj.pojo.HatCity;


public interface HatCityDao {
	/**
	 * 根据主键查询所有县区
	 * @param cityId
	 * @return
	 */
	public List<HatArea> findHatAreaByCityId(String cityId);
	/**
	 * 某部查询
	 */
	public List<HatCity> findHatCityByKw(String kw);
}
