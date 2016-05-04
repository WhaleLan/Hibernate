package hibernate;

import java.util.Date;

public class Student {
	private int sid;
	private String name;
	private String gender;
	private Date birthday;
	private String address;

	public Student()
	{
		
	}
	
	public Student(int sid, String name, String gender, Date birthday, String address) {
		//super();
		this.sid = sid;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", gender=" + gender + ", birthday=" + birthday + ", address="
				+ address + "]";
	}

}
