package cn.kjy.zj.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import cn.kjy.zj.dao.HatCityDao;
import cn.kjy.zj.factory.HibernateSessionFactory;
import cn.kjy.zj.pojo.HatArea;
import cn.kjy.zj.pojo.HatCity;

public class HatCityDaoImpl implements HatCityDao{

	@Override
	public List<HatArea> findHatAreaByCityId(String cityId) {
		try {
			Session session=HibernateSessionFactory.getMySession();
			Query query=session.createQuery("from HatArea a where a.hatCity.cityId=?");
			query.setString(0, cityId);
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateSessionFactory.closeSession();
		}
		return null;
	}

	@Override
	public List<HatCity> findHatCityByKw(String kw) {
		try {
			Session session=HibernateSessionFactory.getMySession();
			Query query = session.createQuery("from HatCity where city like ?");
			query.setParameter(0, "%"+kw+"%");
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateSessionFactory.closeSession();
		}
		return null;
	}
	
}
