package serviceTest;

import org.junit.Test;

import junit.framework.Assert;
import service.UsersDao;
import service.impl.UsersDaoImpl;
import entity.Users;

public class TestUsersDaoImpl {
	@Test
  public void testuserLogin(){
	  Users user=new Users(1,"zhangsan","123456");
	  UsersDao dao=new UsersDaoImpl();
	  Assert.assertEquals(true, dao.userLogin(user));  
  }
}
