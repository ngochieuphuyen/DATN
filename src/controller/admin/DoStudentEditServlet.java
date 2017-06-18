package controller.admin;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Classes;
import model.bean.Student;
import model.bo.ClassesBo;
import model.bo.StudentsBo;

/**
 * Servlet implementation class DoStudentEditServlet
 */
@WebServlet("/DoStudentEdit")
public class DoStudentEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoStudentEditServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idStudent = Integer.parseInt(request.getParameter("IdStudent"));
		StudentsBo studentsBo = new StudentsBo();
		Student student = studentsBo.getStudent(idStudent);
		student.setFullName(request.getParameter("FullName"));
		student.setIdClass(Integer.parseInt(request.getParameter("Class")));
		student.setMale(Boolean.parseBoolean(request.getParameter("Male")));
		student.setPhoneNumber(request.getParameter("PhoneNumber"));
		student.setHomePhone(request.getParameter("HomePhone"));
		String birthday = request.getParameter("Birthday");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = format.parse(birthday);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		student.setBirthday(date);
		if (studentsBo.updateStudent(student)) {
			response.sendRedirect(request.getContextPath() + "/ShowStudents?students=???");
		} else {
			Student student2 = studentsBo.getStudent(idStudent);
			ClassesBo classesBo = new ClassesBo();
			ArrayList<Classes> listClasses = classesBo.getListClass();
			request.setAttribute("student", student2);
			request.setAttribute("listClasses", listClasses);
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/admin/ShowStudentEdit.jsp");
			dispatcher.forward(request, response);
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
