package cn.kjy.zj.test;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import cn.kjy.zj.dao.HatCityDao;
import cn.kjy.zj.dao.impl.HatCityDaoImpl;
import cn.kjy.zj.pojo.HatArea;
import cn.kjy.zj.pojo.HatCity;

public class TestDao {
		public static void main(String[] args) {
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			Session session = sf.openSession();
			/*Query query = session.createQuery("from HatProvince");
			List<HatProvince> lsit = query.list();
			System.out.println(lsit.size());*/
			/*Query query = session.createQuery("from HatCity c where c.hatProvince.provinceId=?");
			query.setParameter(0, "110000");
			List<HatCity> list =query.list();
			System.out.println(list.size());*/
			
			HatCityDao hd=new HatCityDaoImpl();
			List<HatCity> citylist = hd.findHatCityByKw("´ó");
			System.out.println(citylist.size());
		}
}
