package spring_mybatis.entry;

import java.io.Serializable;
import java.util.Date;

public class class_s  implements Serializable{

	private static final long serialVersionUID = -8366929034564774130L;
	
	@Override
	public String toString() {
		return "class_s [class_name=" + class_name + ", create_time=" + create_time + "]";
	}
	
	public class_s() {
	}

	public class_s(int class_id,String class_name, Date create_time) {
		super();
		this.class_id=class_id;
		this.class_name = class_name;
		this.create_time = create_time;
	}
	
	public class_s(String class_name, Date create_time) {
		super();
		this.class_name = class_name;
		this.create_time = create_time;
	}
	

	
	
	
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	
	
	
	public int getClass_id() {
		return class_id;
	}


	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}




	int class_id;
	String class_name;
	Date create_time;
	
}
