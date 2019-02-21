package spring_mybatis.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import spring_mybatis.entry.class_s;


//查询所有的班级信息20190220

public interface classQueryAllMapping {
	@Select("select * from class_s") //用@Select注解sql语句
    List<class_s> findAll();
}
