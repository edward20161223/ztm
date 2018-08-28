package spring_mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring_mybatis.dao.class_sDAO;
import spring_mybatis.entry.class_s;

@Service
public class class_sService {

	@Autowired
	private class_sDAO banjiDao;
	
	public void saveBanji(class_s banji){
		banjiDao.saveBanji(banji);
	}
	
	public class_s getBanji(int banji_id){
		class_s banji=banjiDao.getBanji(banji_id);
		return banji;
	}
}
