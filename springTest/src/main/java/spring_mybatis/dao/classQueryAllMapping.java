package spring_mybatis.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import spring_mybatis.entry.class_s;


//��ѯ���еİ༶��Ϣ20190220

public interface classQueryAllMapping {
	@Select("select * from class_s") //��@Selectע��sql���
    List<class_s> findAll();
}
