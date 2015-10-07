package db;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;

public class MyHibernateSessionFactory {
	private static SessionFactory sessionFactory;// 会话工厂属性

	// 构造方法私有化，保证单例模式
	private MyHibernateSessionFactory() {
		
	}
	//公有的静态方法，获得会话工厂对象
    public static SessionFactory getSeesionFactory(){
    	if(sessionFactory==null){
    		Configuration config=new Configuration();
    		ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().configure().build();
    	    sessionFactory=config.buildSessionFactory(serviceRegistry);
    	    return sessionFactory; 
    	}else{
    		return sessionFactory; 
    	}
    }
}
