package model.bean;

public class Faculty {
	private int IdFaculty;
	private String FacultyName;
	
	public Faculty(){}

	public Faculty(int idFaculty, String facultyName) {
		super();
		IdFaculty = idFaculty;
		FacultyName = facultyName;
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
	
}
