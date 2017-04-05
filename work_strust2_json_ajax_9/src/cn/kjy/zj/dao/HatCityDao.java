package cn.kjy.zj.dao;

import java.util.List;

import cn.kjy.zj.pojo.HatArea;
import cn.kjy.zj.pojo.HatCity;


public interface HatCityDao {
	/**
	 * ����������ѯ��������
	 * @param cityId
	 * @return
	 */
	public List<HatArea> findHatAreaByCityId(String cityId);
	/**
	 * ĳ����ѯ
	 */
	public List<HatCity> findHatCityByKw(String kw);
}
