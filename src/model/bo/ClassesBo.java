package model.bo;

import java.util.ArrayList;

import model.bean.Classes;
import model.dao.ClassesDao;

public class ClassesBo {
	ClassesDao classesDao = new ClassesDao();

	public ArrayList<Classes> getListClass() {
		return (ArrayList<Classes>) classesDao.getListClass();
	}

	public boolean addClass(Classes classes) {
		return (boolean) classesDao.addClass(classes);
	}

	public Classes getClass(int idClass) {
		return (Classes) classesDao.getClass(idClass);
	}

	public boolean updateClass(Classes classes) {
		return (boolean) classesDao.updateClass(classes);
	}

	public ArrayList<Classes> getListClassDetail() {
		return (ArrayList<Classes>) classesDao.getListClassDetail();
	}

	public ArrayList<Classes> getListClassWithFaclty(String idFaculty) {
		return (ArrayList<Classes>) classesDao.getListClassWithFaclty(Integer.parseInt(idFaculty));
	}

	public ArrayList<Classes> getListClassWithCourse(String idCourse) {
		return (ArrayList<Classes>) classesDao.getListClassWithCourse(Integer.parseInt(idCourse));
	}

	public Classes getClassDetail(int idClass) {
		return (Classes) classesDao.getClassDetail(idClass);
	}

	public void deleteClass(int idClass) {
		StudentsBo studentsBo = new StudentsBo();
		while (studentsBo.checkClass(idClass)) {
			int idStudent = studentsBo.getStudentsWithClass(idClass);
			studentsBo.deleteStudent(idStudent);
		}
		classesDao.deleteClass(idClass);

	}

	public boolean checkCourse(int idCourse) {
		return (boolean) classesDao.checkCourse(idCourse);
	}

	public int getClassWithCourse(int idCourse) {
		return (int) classesDao.getClassWithCourse(idCourse);
	}

	public boolean checkFaculty(int idFaculty) {
		return (boolean) classesDao.checkFaculty(idFaculty);
	}

	public int getClassWithFaculty(int idFaculty) {
		return (int) classesDao.getClassWithFaculty(idFaculty);
	}


}
