package cn.kjy.zj.dao;

import java.util.List;

import cn.kjy.zj.pojo.HatCity;
import cn.kjy.zj.pojo.HatProvince;

public interface HatProvinceDao {
	/**
	 * ��ѯ����ʡ��
	 * @return
	 */
	public List<HatProvince> findAll();
	/**
	 * ����������ѯ���еĳ���
	 * @return
	 */
	public List<HatCity> findHatCilyByProvinceId(String provinceId);
}
