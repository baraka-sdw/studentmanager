package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyHibernateSessionFactory;
import entity.Students;
import service.StudentsDao;

public class StudentsDaoImpl implements StudentsDao {

	@Override
	public List<Students> queryAllStudents() {
		Transaction ts = null;
		List<Students> list = null;
		String hql = "";
		try {
			Session session = MyHibernateSessionFactory.getSeesionFactory()
					.getCurrentSession();
			ts=session.beginTransaction();
			hql = "from Students";
			Query query = session.createQuery(hql);
			list = query.list();
			ts.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return list;
		} finally {
            if(ts!=null){
            	ts=null; 
            }
		}
	}

	@Override
	public Students queryStudentById(String sid) {
		Transaction ts = null;
		Students s=null;
		try {
			Session session = MyHibernateSessionFactory.getSeesionFactory()
					.getCurrentSession();
			ts=session.beginTransaction();
			s=session.get(Students.class, sid);
			ts.commit();
			return s;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
            if(ts!=null){
            	ts=null; 
            }
		}
		return null;
	}

	@Override
	public boolean addStudent(Students s) {
		Transaction ts=null;
		s.setSid(getNewSid());
		try {
			Session session = MyHibernateSessionFactory.getSeesionFactory()
					.getCurrentSession();
			ts=session.beginTransaction();
			session.save(s);
			ts.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
            if(ts!=null){
            	ts=null; 
            }
		}
	}

	@Override
	public boolean updateStudents(Students s) {
		Transaction ts=null;
		try {
			Session session = MyHibernateSessionFactory.getSeesionFactory()
					.getCurrentSession();
			ts=session.beginTransaction();
			session.update(s);
			ts.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
            if(ts!=null){
            	ts=null; 
            }
		}
	}

	@Override
	public boolean deleteStudent(String id) {
		Transaction ts = null;
		try {
			Session session = MyHibernateSessionFactory.getSeesionFactory()
					.getCurrentSession();
			ts=session.beginTransaction();
			Students s=session.get(Students.class, id);
			session.delete(s);
			ts.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
            if(ts!=null){
            	ts=null; 
            }
		}
	}
	//生成学生的学号
		public String getNewSid(){
			Transaction ts = null;
			String hql="";
			String sid= null;
			try {
				Session session = MyHibernateSessionFactory.getSeesionFactory()
						.getCurrentSession();
				ts=session.beginTransaction();
				hql="select max(sid) from Students";
				Query query=session.createQuery(hql);
				sid=(String) query.uniqueResult();
				if(sid==null||"".equals(sid)){
					sid="S201501";
				}else{
					String temp=sid.substring(1);
					int i=Integer.parseInt(temp);
					++i;
					temp=String.valueOf(i);
					for(int j=0;j<6-temp.length();j++){
						temp=temp+"0";
					}
					sid="S"+temp;
				}
				return sid;
			} catch (Exception e) {
				e.printStackTrace();
				return "";
			} finally {
	            if(ts!=null){
	            	ts=null; 
	            }
			}
		}
}
