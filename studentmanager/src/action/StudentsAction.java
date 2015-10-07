package action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.ActionContext;

import entity.Students;
import service.StudentsDao;
import service.impl.StudentsDaoImpl;

public class StudentsAction extends SuperAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    //查询所有
	public String query(){
		StudentsDao dao=new StudentsDaoImpl();
		List<Students> list=dao.queryAllStudents();
		if(list!=null&&list.size()>0){
			HttpSession session =req.getSession();
			session.setAttribute("students_list", list);
			
		}
		return "query_success";
	}
    //删除
	public String delete(){
		StudentsDao dao=new StudentsDaoImpl();
		String id=req.getParameter("sid");
		dao.deleteStudent(id);
		return "delete_success";
	}
	//修改
	public String modify(){
		StudentsDao dao=new StudentsDaoImpl();
		String sid=req.getParameter("sid");
		Students s=dao.queryStudentById(sid);
		HttpSession session =req.getSession();
		session.setAttribute("modify_students", s);
		System.out.println(s);
		return "modify_success";
		
	}
	public String add() throws ParseException{
		Students s=new Students();
		s.setSname(req.getParameter("sname"));
		s.setGender(req.getParameter("gender"));
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		s.setBirthday(sdf.parse((req.getParameter("birthday"))));
		s.setAddress(req.getParameter("address"));
		StudentsDao dao=new StudentsDaoImpl();
		dao.addStudent(s);
		return "add_success";
		
	}
	public String save() throws ParseException{
		Students s=new Students();
		s.setSid(req.getParameter("sid"));
		s.setSname(req.getParameter("sname"));
		s.setGender(req.getParameter("gender"));
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		s.setBirthday(sdf.parse(req.getParameter("birthday")));
		s.setAddress(req.getParameter("address"));
		System.out.println(s);
		StudentsDao dao=new StudentsDaoImpl();
		dao.updateStudents(s);
		return "update_success";
	}
}
