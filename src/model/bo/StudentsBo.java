package model.bo;

import java.util.ArrayList;

import model.bean.Student;
import model.dao.StudentsDao;

public class StudentsBo {
	StudentsDao studentsDao = new StudentsDao();

	public ArrayList<Student> getListStudents() {
		return (ArrayList<Student>) studentsDao.getListStudents();
	}

	public boolean addStudent(Student student, String email) {
		return (boolean) studentsDao.addStudent(student, email);
	}

	public Student getStudent(int idStudent) {
		return (Student) studentsDao.getStudent(idStudent);
	}

	public boolean updateStudent(Student student) {
		return (boolean) studentsDao.updateStudent(student);
	}

	public ArrayList<Student> getListStudentsWithClass(String idClass) {
		return (ArrayList<Student>) studentsDao.getListStudentsWithClass(Integer.parseInt(idClass));
	}

	public void deleteStudent(int idStudent) {
		AccountBo accountBo = new AccountBo();
		int idAccount = getAccount(idStudent);
		studentsDao.deleteStudent(idStudent);
		accountBo.deleteAccount(idAccount);
	}

	private int getAccount(int idStudent) {
		return studentsDao.getAccount(idStudent);
	}

	public boolean checkClass(int idClass) {
		return (boolean) studentsDao.checkClass(idClass);
	}

	public int getStudentsWithClass(int idClass) {
		return (int) studentsDao.getStudentsWithClass(idClass);
	}

	public Student getStudentWithAccount(int idAccount) {
		return (Student) studentsDao.getStudentWithAccount(idAccount);
	}

	public Student getStudentWithAccountDetail(int idAccount) {
		return (Student) studentsDao.getStudentWithAccountDetail(idAccount);
	}

}
