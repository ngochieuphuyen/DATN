package model.bo;

import java.util.ArrayList;

import model.bean.Faculty;
import model.dao.FacultyDao;

public class FacultyBo {
	FacultyDao facultyDao = new FacultyDao();

	public ArrayList<Faculty> getListFaculty() {
		return (ArrayList<Faculty>) facultyDao.getListFaculty();
	}

	public boolean addFaculty(String facultyName) {
		return (boolean) facultyDao.addFaculty(facultyName);
	}

	public Faculty getFaculty(int idFaculty) {
		return (Faculty) facultyDao.getFaculty(idFaculty);
	}

	public boolean updateFaculty(Faculty faculty) {
		return (boolean) facultyDao.updateFaculty(faculty);
	}

	public void deleteFaculty(int idFaculty) {
		ClassesBo classesBo = new ClassesBo();
		while (classesBo.checkFaculty(idFaculty)) {
			int idClass = classesBo.getClassWithFaculty(idFaculty);
			classesBo.deleteClass(idClass);
		}
		facultyDao.deleteFaculty(idFaculty);
	}

}
