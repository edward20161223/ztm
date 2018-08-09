package spring_mybatis.dao;

import spring_mybatis.entry.student;

public interface studentDAO {
	   public void save(student student);
	   public student getStudent(int id);
}
