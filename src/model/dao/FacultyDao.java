package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conn.ConnectionUtils;
import model.bean.Faculty;

public class FacultyDao {
	Connection conn = ConnectionUtils.getConnection();

	public ArrayList<Faculty> getListFaculty() {
		String sql = "select IdFaculty, FacultyName from Faculty";
		ArrayList<Faculty> listFaculty = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Faculty faculty = new Faculty();
				faculty.setIdFaculty(rs.getInt("IdFaculty"));
				faculty.setFacultyName(rs.getString("FacultyName"));
				listFaculty.add(faculty);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listFaculty;
	}

	public boolean addFaculty(String facultyName) {
		String sql = "insert into Faculty values(?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, facultyName);
			if (ps.executeUpdate() > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Faculty getFaculty(int idFaculty) {
		String sql = "select FacultyName from Faculty where IdFaculty =" + idFaculty;
		Faculty faculty = new Faculty();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				faculty.setIdFaculty(idFaculty);
				faculty.setFacultyName(rs.getString("FacultyName"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return faculty;
	}

	public boolean updateFaculty(Faculty faculty) {
		String sql = "update Faculty set FacultyName=? where IdFaculty=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, faculty.getFacultyName());
			ps.setInt(2, faculty.getIdFaculty());
			if (ps.executeUpdate() > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public void deleteFaculty(int idFaculty) {
		String sql = "delete from Faculty where IdFaculty = ?";
		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idFaculty);
			if (ps.executeUpdate() > 0)
				System.out.println("deleted faculty");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
