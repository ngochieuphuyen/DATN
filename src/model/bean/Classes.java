package model.bean;

public class Classes {
	private int IdClass;
	private String ClassName;
	private int TotalNumberStudent;
	private int IdFaculty;
	private String FacultyName;
	private int IdCourse;
	private String CourseName;
	
	public Classes(){}

	public Classes(int idClass, String className, int totalNumberStudent, int idFaculty, String facultyName,
			int idCourse, String courseName) {
		IdClass = idClass;
		ClassName = className;
		TotalNumberStudent = totalNumberStudent;
		IdFaculty = idFaculty;
		FacultyName = facultyName;
		IdCourse = idCourse;
		CourseName = courseName;
	}

	public int getIdClass() {
		return IdClass;
	}

	public void setIdClass(int idClass) {
		IdClass = idClass;
	}

	public String getClassName() {
		return ClassName;
	}

	public void setClassName(String className) {
		ClassName = className;
	}

	public int getTotalNumberStudent() {
		return TotalNumberStudent;
	}

	public void setTotalNumberStudent(int totalNumberStudent) {
		TotalNumberStudent = totalNumberStudent;
	}

	public int getIdFaculty() {
		return IdFaculty;
	}

	public void setIdFaculty(int idFaculty) {
		IdFaculty = idFaculty;
	}

	public String getFacultyName() {
		return FacultyName;
	}

	public void setFacultyName(String facultyName) {
		FacultyName = facultyName;
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
