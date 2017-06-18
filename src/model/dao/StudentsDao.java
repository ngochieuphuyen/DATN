package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import conn.ConnectionUtils;
import model.bean.Account;
import model.bean.Classes;
import model.bean.Student;

public class StudentsDao {
	Connection conn = ConnectionUtils.getConnection();

	public ArrayList<Student> getListStudents() {
		ArrayList<Student> listStudents = new ArrayList<>();
		String sql = "select IdStudent, FullName, StudentNumber from Students";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setIdStudent(rs.getInt("IdStudent"));
				student.setFullName(rs.getString("FullName"));
				// student.setBirthday(rs.getDate("Birthday"));
				// student.setMale(rs.getBoolean("IsMale"));
				student.setStudentNumber(rs.getString("StudentNumber"));
				// student.setIdClass(rs.getInt("IdClass"));
				// student.setIdAccount(rs.getInt("IdAccount"));
				// student.setPhoneNumber(rs.getString("PhoneNumber"));
				// student.setHomePhone(rs.getString("HomePhone"));

				listStudents.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listStudents;
	}

	public boolean addStudent(Student student, String email) {
		DecentralizationDao dao = new DecentralizationDao();
		AccountDao accountDao = new AccountDao();
		Account account = new Account();
		account.setUsername(student.getStudentNumber());
		account.setPassword(student.getStudentNumber());
		account.setEmail(email);
		account.setTypeAccount(dao.getIdDecentrlization("User"));
		if (accountDao.addAccount(account)) {
			student.setIdAccount(accountDao.getIdAccount(account.getUsername()));
			String sql = "insert into Students values(?,?,?,?,?,?,?,?)";
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, student.getFullName());
				DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				String birthday = format.format(student.getBirthday());
				java.sql.Date date = new java.sql.Date(0000 - 00 - 00);
				ps.setDate(2, date.valueOf(birthday));
				ps.setBoolean(3, student.isMale());
				ps.setString(4, student.getStudentNumber());
				ps.setInt(5, student.getIdClass());
				ps.setInt(6, student.getIdAccount());
				ps.setString(7, student.getPhoneNumber());
				ps.setString(8, student.getHomePhone());
				if (ps.executeUpdate() > 0)
					return true;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("student");
			}
		}

		return false;
	}

	public Student getStudent(int idStudent) {
		Student student = new Student();
		String sql = "select FullName, Birthday, IsMale, StudentNumber, IdClass, IdAccount, PhoneNumber, HomePhone from Students  where IdStudent ="
				+ idStudent;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				student.setIdStudent(idStudent);
				student.setFullName(rs.getString("FullName"));
				student.setBirthday(rs.getDate("Birthday"));
				student.setMale(rs.getBoolean("IsMale"));
				student.setStudentNumber(rs.getString("StudentNumber"));
				student.setIdClass(rs.getInt("IdClass"));
				student.setIdAccount(rs.getInt("IdAccount"));
				student.setPhoneNumber(rs.getString("PhoneNumber"));
				student.setHomePhone(rs.getString("HomePhone"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}

	public boolean updateStudent(Student student) {
		String sql = "update Students set FullName=?, Birthday=?, IsMale=?, IdClass=?, PhoneNumber=?, HomePhone=? where IdStudent=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, student.getFullName());
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String birthday = format.format(student.getBirthday());
			java.sql.Date date = new java.sql.Date(0000 - 00 - 00);
			ps.setDate(2, date.valueOf(birthday));
			ps.setBoolean(3, student.isMale());
			ps.setInt(4, student.getIdClass());
			ps.setString(5, student.getPhoneNumber());
			ps.setString(6, student.getHomePhone());
			ps.setInt(7, student.getIdStudent());
			if (ps.executeUpdate() > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<Student> getListStudentsWithClass(int idClass) {
		ArrayList<Student> listStudents = new ArrayList<>();
		String sql = "select IdStudent, FullName, StudentNumber, PhoneNumber from Students where IdClass =" + idClass;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setIdStudent(rs.getInt("IdStudent"));
				student.setFullName(rs.getString("FullName"));
//				student.setBirthday(rs.getDate("Birthday"));
//				student.setMale(rs.getBoolean("IsMale"));
				student.setStudentNumber(rs.getString("StudentNumber"));
//				student.setIdClass(rs.getInt("IdClass"));
//				student.setIdAccount(rs.getInt("IdAccount"));
				student.setPhoneNumber(rs.getString("PhoneNumber"));
//				student.setHomePhone(rs.getString("HomePhone"));

				listStudents.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listStudents;
	}

	public int getAccount(int idStudent) {
		String sql = "select IdAccount from Students where IdStudent =" + idStudent;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return rs.getInt("IdAccount");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public void deleteStudent(int idStudent) {
		String sql = "delete from Students where IdStudent = ?";
		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idStudent);
			if (ps.executeUpdate() > 0)
				System.out.println("deleted student");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean checkClass(int idClass) {
		String sql = "select IdStudent from Students where IdClass =" + idClass;
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

	public int getStudentsWithClass(int idClass) {
		String sql = "select IdStudent from Students where IdClass =" + idClass;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return rs.getInt("IdStudent");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public Student getStudentWithAccount(int idAccount) {
		Student student = new Student();
		String sql = "select IdStudent, FullName, Birthday, IsMale, StudentNumber, IdClass, PhoneNumber, HomePhone from Students  where IdAccount =" + idAccount;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				student.setIdStudent(rs.getInt("IdStudent"));
				student.setFullName(rs.getString("FullName"));
				student.setBirthday(rs.getDate("Birthday"));
				student.setMale(rs.getBoolean("IsMale"));
				student.setStudentNumber(rs.getString("StudentNumber"));
				student.setIdClass(rs.getInt("IdClass"));
				student.setIdAccount(idAccount);
				student.setPhoneNumber(rs.getString("PhoneNumber"));
				student.setHomePhone(rs.getString("HomePhone"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}

	public Student getStudentWithAccountDetail(int idAccount) {
		Student student = new Student();
		String sql = "select FullName, Birthday, IsMale, StudentNumber, IdClass, PhoneNumber, HomePhone from Students  where IdAccount =" + idAccount;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ClassesDao classesDao = new ClassesDao();
			Classes classes = new Classes();
			while (rs.next()) {
//				student.setIdStudent(rs.getInt("IdStudent"));
				student.setFullName(rs.getString("FullName"));
				student.setBirthday(rs.getDate("Birthday"));
				student.setMale(rs.getBoolean("IsMale"));
				student.setStudentNumber(rs.getString("StudentNumber"));
				student.setIdClass(rs.getInt("IdClass"));
				
				classes = classesDao.getClassDetail(student.getIdClass());
				student.setClassName(classes.getClassName());
				student.setFacultyName(classes.getFacultyName());
				student.setCourseName(classes.getCourseName());
				
				student.setPhoneNumber(rs.getString("PhoneNumber"));
				student.setHomePhone(rs.getString("HomePhone"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}

}
