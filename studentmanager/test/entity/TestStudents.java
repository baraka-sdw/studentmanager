package entity;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.internal.MetadataBuilderImpl;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;


public class TestStudents {
//	   @Test
//       public void testShchemaExport(){
//        	//创建服务注册对象
//        	ServiceRegistry sr=new StandardServiceRegistryBuilder().configure().build();
//        	//创建sessionFactory
//        	MetadataImplementor mi=(MetadataImplementor) new MetadataSources(sr).buildMetadata();
//        	//创建SchemaReport对象
//        	SchemaExport se=new SchemaExport(mi);
//        	se.create(true, true);
//        }
//        public static void main(String[] args) {
//			TestStudents ts=new TestStudents();
//			ts.testShchemaExport();
//		}
	   @Test
        public void testSaveStudents(){
        	//创建服务注册对象
        	ServiceRegistry sr=new StandardServiceRegistryBuilder().configure().build();
        	//创建sessionFactory
        	MetadataImplementor mi=(MetadataImplementor) new MetadataSources(sr).buildMetadata();
            SessionFactory sf=new Configuration().buildSessionFactory(sr);
            Session session=sf.getCurrentSession();
        	//创建事务对象
        	Transaction ts=session.beginTransaction();
        	Students s1=new Students("S20151","张三丰","男",new Date(),"武当山");
        	Students s2=new Students("S20152","孙悟空","男",new Date(),"火花果山");
        	Students s3=new Students("S20153","马云","男",new Date(),"火星");
        	session.save(s1);
        	session.save(s2);
        	session.save(s3);
        	System.out.println(s1.toString());
        	ts.commit();
        	sf.close();
        }
}
