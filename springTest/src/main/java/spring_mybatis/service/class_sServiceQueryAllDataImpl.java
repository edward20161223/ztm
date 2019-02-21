package spring_mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring_mybatis.entry.class_s;


@Service("class_sServiceQueryAllData")
public class class_sServiceQueryAllDataImpl implements class_sServiceQueryAllData{

    @Autowired
    private spring_mybatis.dao.classQueryAllMapping classQueryAllMapping; //用AutoWired注入DB层

    @Transactional(readOnly=true) //数据库的读取方式为：只读   
	@Override
	public List<class_s> getAll() {
		return classQueryAllMapping.findAll();
	}

}
