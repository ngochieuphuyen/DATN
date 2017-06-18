package controller.admin;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Student;
import model.bo.StudentsBo;

/**
 * Servlet implementation class DoStudentAddServlet
 */
@WebServlet("/DoStudentAdd")
public class DoStudentAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoStudentAddServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentsBo studentsBo = new StudentsBo();
		Student student = new Student();
		student.setFullName(request.getParameter("FullName"));
		student.setStudentNumber(request.getParameter("StudentNumber"));
		student.setIdClass(Integer.parseInt(request.getParameter("Class")));
		student.setMale(Boolean.parseBoolean(request.getParameter("Male")));
		student.setPhoneNumber(request.getParameter("PhoneNumber"));
		student.setHomePhone(request.getParameter("HomePhone"));
		String Email = request.getParameter("Email");
		String birthday = request.getParameter("Birthday");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = format.parse(birthday);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		student.setBirthday(date);

		if (studentsBo.addStudent(student, Email)) {
			response.sendRedirect(request.getContextPath() + "/ShowStudents?students=???");
		} else {
			response.sendRedirect(request.getContextPath() + "/ShowStudentAdd");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
