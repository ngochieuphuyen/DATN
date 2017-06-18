package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conn.ConnectionUtils;
import model.bean.Classes;

public class ClassesDao {
	Connection conn = ConnectionUtils.getConnection();

	public ArrayList<Classes> getListClass() {
		ArrayList<Classes> listClass = new ArrayList<>();
		String sql = "select IdClass, ClassName from Classes";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Classes classes = new Classes();
				classes.setIdClass(rs.getInt("IdClass"));
				classes.setClassName(rs.getString("ClassName"));
//				classes.setTotalNumberStudent(rs.getInt("TotalNumberStudent"));
//				classes.setIdFaculty(rs.getInt("IdFaculty"));
//				classes.setIdCourse(rs.getInt("IdCourse"));

				listClass.add(classes);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listClass;
	}

	public boolean addClass(Classes classes) {
		String sql = "insert into Classes values(?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, classes.getClassName());
			ps.setInt(2, classes.getTotalNumberStudent());
			ps.setInt(3, classes.getIdFaculty());
			ps.setInt(4, classes.getIdCourse());
			if (ps.executeUpdate() > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Classes getClass(int idClass) {
		Classes classes = new Classes();
		String sql = "select ClassName, TotalNumberStudent, IdFaculty, IdCourse from Classes where IdClass =" + idClass;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				classes.setIdClass(idClass);
				classes.setClassName(rs.getString("ClassName"));
				classes.setTotalNumberStudent(rs.getInt("TotalNumberStudent"));
				classes.setIdFaculty(rs.getInt("IdFaculty"));
				classes.setIdCourse(rs.getInt("IdCourse"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return classes;
	}

	public boolean updateClass(Classes classes) {
		String sql = "update Classes set ClassName=?, TotalNumberStudent=?, IdFaculty=?, IdCourse=? where IdClass=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, classes.getClassName());
			ps.setInt(2, classes.getTotalNumberStudent());
			ps.setInt(3, classes.getIdFaculty());
			ps.setInt(4, classes.getIdCourse());
			ps.setInt(5, classes.getIdClass());
			if (ps.executeUpdate() > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<Classes> getListClassDetail() {
		ArrayList<Classes> listClass = new ArrayList<>();
		String sql = "select IdClass, ClassName, TotalNumberStudent, IdFaculty, IdCourse from Classes";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			FacultyDao facultyDao = new FacultyDao();
			CoursesDao coursesDao = new CoursesDao();
			while (rs.next()) {
				Classes classes = new Classes();
				classes.setIdClass(rs.getInt("IdClass"));
				classes.setClassName(rs.getString("ClassName"));
				classes.setTotalNumberStudent(rs.getInt("TotalNumberStudent"));
				classes.setIdFaculty(rs.getInt("IdFaculty"));
				classes.setFacultyName(facultyDao.getFaculty(classes.getIdFaculty()).getFacultyName());
				classes.setIdCourse(rs.getInt("IdCourse"));
				classes.setCourseName(coursesDao.getCourse(classes.getIdCourse()).getCourseName());

				listClass.add(classes);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listClass;
	}

	public ArrayList<Classes> getListClassWithFaclty(int idFaculty) {
		ArrayList<Classes> listClasses = new ArrayList<>();
		String sql = "select IdClass, ClassName from Classes where IdFaculty =" + idFaculty;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Classes classes = new Classes();
				classes.setIdClass(rs.getInt("IdClass"));
				classes.setClassName(rs.getString("ClassName"));
//				classes.setTotalNumberStudent(rs.getInt("TotalNumberStudent"));
//				classes.setIdFaculty(rs.getInt("IdFaculty"));
//				classes.setIdCourse(rs.getInt("IdCourse"));

				listClasses.add(classes);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listClasses;
	}

	public ArrayList<Classes> getListClassWithCourse(int idCourse) {
		ArrayList<Classes> listClasses = new ArrayList<>();
		String sql = "select IdClass, ClassName from Classes where IdCourse =" + idCourse;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Classes classes = new Classes();
				classes.setIdClass(rs.getInt("IdClass"));
				classes.setClassName(rs.getString("ClassName"));
//				classes.setTotalNumberStudent(rs.getInt("TotalNumberStudent"));
//				classes.setIdFaculty(rs.getInt("IdFaculty"));
//				classes.setIdCourse(rs.getInt("IdCourse"));

				listClasses.add(classes);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listClasses;
	}

	public Classes getClassDetail(int idClass) {
		String sql = "select ClassName, TotalNumberStudent, IdFaculty, IdCourse from Classes where IdClass =" + idClass;
		Classes classes = new Classes();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			FacultyDao facultyDao = new FacultyDao();
			CoursesDao coursesDao = new CoursesDao();
			if (rs.next()) {
				classes.setIdClass(idClass);
				classes.setClassName(rs.getString("ClassName"));
				classes.setTotalNumberStudent(rs.getInt("TotalNumberStudent"));
				classes.setIdFaculty(rs.getInt("IdFaculty"));
				classes.setFacultyName(facultyDao.getFaculty(classes.getIdFaculty()).getFacultyName());
				classes.setIdCourse(rs.getInt("IdCourse"));
				classes.setCourseName(coursesDao.getCourse(classes.getIdCourse()).getCourseName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return classes;
	}

	public void deleteClass(int idClass) {
		String sql = "delete from Classes where IdClass = ?";
		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idClass);
			if (ps.executeUpdate() > 0)
				System.out.println("deleted class");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean checkCourse(int idCourse) {
		String sql = "select IdClass from Classes where IdCourse =" + idCourse;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public int getClassWithCourse(int idCourse) {
		String sql = "select IdClass from Classes where IdCourse =" + idCourse;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return rs.getInt("IdClass");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public boolean checkFaculty(int idFaculty) {
		String sql = "select IdClass from Classes where IdFaculty =" + idFaculty;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public int getClassWithFaculty(int idFaculty) {
		String sql = "select IdClass from Classes where IdFaculty =" + idFaculty;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return rs.getInt("IdClass");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}


}
