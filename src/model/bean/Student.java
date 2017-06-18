package model.bean;

import java.util.Date;

public class Student {
	private int IdStudent;
	private String FullName;
	private Date Birthday;
	private boolean isMale;
	private String StudentNumber;
	private int IdClass;
	private String ClassName;
	private String FacultyName;
	private String CourseName;
	private int IdAccount;
	private String PhoneNumber;
	private String HomePhone;
	
	public Student(){}

	

	public String getClassName() {
		return ClassName;
	}



	public void setClassName(String className) {
		ClassName = className;
	}



	public String getFacultyName() {
		return FacultyName;
	}



	public void setFacultyName(String facultyName) {
		FacultyName = facultyName;
	}



	public String getCourseName() {
		return CourseName;
	}



	public void setCourseName(String courseName) {
		CourseName = courseName;
	}



	public int getIdStudent() {
		return IdStudent;
	}

	public void setIdStudent(int idStudent) {
		IdStudent = idStudent;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
	}

	public Date getBirthday() {
		return Birthday;
	}

	public void setBirthday(Date birthday) {
		Birthday = birthday;
	}

	public boolean isMale() {
		return isMale;
	}

	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}

	public String getStudentNumber() {
		return StudentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		StudentNumber = studentNumber;
	}

	public int getIdClass() {
		return IdClass;
	}

	public void setIdClass(int idClass) {
		IdClass = idClass;
	}

	public int getIdAccount() {
		return IdAccount;
	}

	public void setIdAccount(int idAccount) {
		IdAccount = idAccount;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getHomePhone() {
		return HomePhone;
	}

	public void setHomePhone(String homePhone) {
		HomePhone = homePhone;
	}
	
}
