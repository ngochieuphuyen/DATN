package model.bo;

import java.util.ArrayList;

import model.bean.Courses;
import model.dao.CoursesDao;

public class CoursesBo {
	CoursesDao coursesDao = new CoursesDao();

	public ArrayList<Courses> getListCourses() {
		return (ArrayList<Courses>) coursesDao.getListCourses();
	}

	public boolean addCourse(String courseName) {
		return (boolean) coursesDao.addCourse(courseName);
	}

	public Courses getCourse(int idCourse) {
		return (Courses) coursesDao.getCourse(idCourse);
	}

	public boolean updateCourse(Courses course) {
		return (boolean) coursesDao.updateCourse(course);
	}

	public void deleteCourse(int idCourse) {
		ClassesBo classesBo = new ClassesBo();
		while (classesBo.checkCourse(idCourse)) {
			int idClass = classesBo.getClassWithCourse(idCourse);
			classesBo.deleteClass(idClass);
		}
		coursesDao.deleteCourse(idCourse);

	}

}
