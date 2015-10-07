package service;

import java.util.List;

import entity.Students;

//学生业务逻辑
public interface StudentsDao {
       public List<Students> queryAllStudents();
       public Students queryStudentById	(String id);
       public boolean addStudent(Students s);
       public boolean updateStudents(Students s);
       public boolean deleteStudent(String id);
       
}
