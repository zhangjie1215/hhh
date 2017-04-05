package cn.kjy.zj.factory;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
	private static Configuration cf=null;
	private static SessionFactory sf=null;
	private static ThreadLocal<Session> tl=new ThreadLocal<Session>();
	
	static{
		try {
			cf=new Configuration().configure();
			sf=cf.buildSessionFactory();
		} catch (HibernateException e) {
			System.out.println("数据库连接失败");
			e.printStackTrace();
		}
	}
	
	public static Session getMySession(){
		Session session=tl.get();
		if(session==null){
			session=sf.openSession();
		}
		tl.set(session);
		return session;
	}
	
	public static void closeSession(){
		Session session=tl.get();
		if(session!=null){
			session.close();
		}
		tl.set(null);
	}
}
