package spring_mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring_mybatis.dao.studentDAO;
import spring_mybatis.entry.student;

@Service
public class StudentService {
    @Autowired
    private studentDAO studentDao;
   
    public void save(student student) {
       studentDao.save(student);
    }
   
    public student getStudent(int id) {
    	student student =studentDao.getStudent(id);
       return student;
    }
}
