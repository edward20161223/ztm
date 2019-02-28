package spring_mybatis.entry;

public class student {
	
	public student(){
		
	}
	
	@Override
	public String toString(){
		return "student [name=" + name + ", age=" + age + ", school_number=" + school_number + ", class_s=" + class_s + "]";
	}
	
	public student(String name, int age, String school_number, int class_s) {	
		this.name = name;
		this.age = age;
		this.school_number = school_number;
		this.class_s = class_s;
	}
	
	
	public student(int id, String name, int age, String school_number, int class_s) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.school_number = school_number;
		this.class_s = class_s;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSchool_number() {
		return school_number;
	}
	public void setSchool_number(String school_number) {
		this.school_number = school_number;
	}
	public int getClass_s() {
		return class_s;
	}
	public void setClass_s(int class_s) {
		this.class_s = class_s;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	int id;
	String name;
	int age;
	String school_number;
	int class_s;

}
