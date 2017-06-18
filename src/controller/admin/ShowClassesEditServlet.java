package controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Classes;
import model.bean.Courses;
import model.bean.Faculty;
import model.bo.ClassesBo;
import model.bo.CoursesBo;
import model.bo.FacultyBo;

/**
 * Servlet implementation class ShowClassesEditServlet
 */
@WebServlet("/ShowClassesEdit")
public class ShowClassesEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowClassesEditServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String decentralization = (String) session.getAttribute("decentralization");
		if ("user".equals(decentralization)) {
			response.sendRedirect(request.getContextPath() + "/DoLogout");
		} else if ("admin".equals(decentralization)) {
			int idClass = Integer.parseInt(request.getParameter("idClass"));
			ClassesBo classesBo = new ClassesBo();
			Classes classes = classesBo.getClass(idClass);
			FacultyBo facultyBo = new FacultyBo();
			CoursesBo coursesBo = new CoursesBo();
			ArrayList<Faculty> listFaculty = facultyBo.getListFaculty();
			ArrayList<Courses> listCourse = coursesBo.getListCourses();

			request.setAttribute("class", classes);
			request.setAttribute("listFaculty", listFaculty);
			request.setAttribute("listCourse", listCourse);
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/admin/ShowClassesEdit.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/ShowLogin");
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
