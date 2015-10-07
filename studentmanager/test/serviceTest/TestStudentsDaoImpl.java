package serviceTest;

import java.util.Date;
import java.util.List;


import org.junit.Test;

import service.StudentsDao;
import service.impl.StudentsDaoImpl;
import entity.Students;

public class TestStudentsDaoImpl {
//	    @Test
	    public void testQueryAllStudents(){
	    	StudentsDao dao=new StudentsDaoImpl();
	    	List<Students>  list=dao.queryAllStudents();
	    	for(int i=0;i<list.size();i++){
	    		System.out.println(list.get(i));
	    	}
	    }
//	    @Test
        public void testGetNewSid(){
        	StudentsDaoImpl dao=new StudentsDaoImpl();
        	System.out.println(dao.getNewSid());
        }
        @Test
        public void testAddStudent(){
        	Students s=new Students();
        	s.setSname("马云");
        	s.setBirthday(new Date());
        	s.setGender("男");
        	s.setAddress("火星");
        	StudentsDao dao= new StudentsDaoImpl();
        	dao.addStudent(s);
        }
}
