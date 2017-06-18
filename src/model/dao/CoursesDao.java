package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conn.ConnectionUtils;
import model.bean.Courses;

public class CoursesDao {
	Connection conn = ConnectionUtils.getConnection();

	public ArrayList<Courses> getListCourses() {
		ArrayList<Courses> listCourse = new ArrayList<>();
		String sql = "select IdCourse, CourseName from Courses";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Courses courses = new Courses();
				courses.setIdCourse(rs.getInt("IdCourse"));
				courses.setCourseName(rs.getString("CourseName"));

				listCourse.add(courses);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listCourse;
	}

	public boolean addCourse(String courseName) {
		String sql = "insert into Courses values(?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, courseName);
			if (ps.executeUpdate() > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Courses getCourse(int idCourse) {
		String sql = "select CourseName from Courses where IdCourse =" + idCourse;
		Courses course = new Courses();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				course.setIdCourse(idCourse);
				course.setCourseName(rs.getString("CourseName"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return course;
	}

	public boolean updateCourse(Courses course) {
		String sql = "update Courses set CourseName=? where IdCourse=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, course.getCourseName());
			ps.setInt(2, course.getIdCourse());
			if (ps.executeUpdate() > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public void deleteCourse(int idCourse) {
		String sql = "delete from Courses where IdCourse = ?";
		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idCourse);
			if (ps.executeUpdate() > 0)
				System.out.println("deleted course");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
