package cn.kjy.zj.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import cn.kjy.zj.dao.HatProvinceDao;
import cn.kjy.zj.factory.HibernateSessionFactory;
import cn.kjy.zj.pojo.HatCity;
import cn.kjy.zj.pojo.HatProvince;

public class HatProvinceDaoImpl implements HatProvinceDao{

	@Override
	public List<HatProvince> findAll() {
		try {
			Session session = HibernateSessionFactory.getMySession();
			Criteria ct=session.createCriteria(HatProvince.class);
			return ct.list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateSessionFactory.closeSession();
		}
		return null;
	}

	@Override
	public List<HatCity> findHatCilyByProvinceId(String provinceId) {
		try {
			Session session = HibernateSessionFactory.getMySession();
			Query query=session.createQuery("from HatCity c where c.hatProvince.provinceId=?");
			query.setString(0, provinceId);
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			System.out.println("sss");
			HibernateSessionFactory.closeSession();
		}
		return null;
	}

	

}
