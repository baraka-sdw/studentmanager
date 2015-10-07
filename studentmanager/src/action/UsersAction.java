package action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.validation.SkipValidation;

import service.UsersDao;
import service.impl.UsersDaoImpl;

import com.opensymphony.xwork2.ModelDriven;

import entity.Users;

public class UsersAction extends  SuperAction implements ModelDriven<Users>{
       private Users user=new Users();
       public String login(){
    	   UsersDao dao=new UsersDaoImpl();
    	   if(dao.userLogin(user)){
    		   HttpSession session =req.getSession();
    		   session.setAttribute("loginUserName", user.getUsername());
    		   return "login_success";
    	   }else{
    		   return "login_failure";
    	   }
       }
       @SkipValidation
       //用户注销
       public String logout(){
    	   HttpSession session =req.getSession();
    	   if(session.getAttribute("loginUserName")!=null){
    		   session.removeAttribute("loginUserName");
    	   }
    	   return "logout_success";
       }
       public Users getModel(){
		return this.user;
    	   
       }
	@Override
	public void validate() {
		//用户名不能为空
		if("".equals(user.getUsername().trim())){
			this.addFieldError("usernameError", "用户名不能为空");
		}
		if(user.getPassword().length()<6){
			this.addFieldError("passwordError", "密码长度不少于6位");
		}
	}
       
}
