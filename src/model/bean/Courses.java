package model.bean;

public class Courses {
	private int IdCourse;
	private String CourseName;
	
	public Courses(){}

	public Courses(int idCourse, String courseName) {
		super();
		IdCourse = idCourse;
		CourseName = courseName;
	}

	public int getIdCourse() {
		return IdCourse;
	}

	public void setIdCourse(int idCourse) {
		IdCourse = idCourse;
	}

	public String getCourseName() {
		return CourseName;
	}

	public void setCourseName(String courseName) {
		CourseName = courseName;
	}

	
}
