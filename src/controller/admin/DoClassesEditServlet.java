package controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Classes;
import model.bean.Courses;
import model.bean.Faculty;
import model.bo.ClassesBo;
import model.bo.CoursesBo;
import model.bo.FacultyBo;

/**
 * Servlet implementation class DoClassesEditServlet
 */
@WebServlet("/DoClassesEdit")
public class DoClassesEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoClassesEditServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idClass = Integer.parseInt(request.getParameter("idClass"));
		ClassesBo classesBo = new ClassesBo();
		Classes classes = classesBo.getClass(idClass);
		classes.setClassName(request.getParameter("ClassName"));
		classes.setTotalNumberStudent(Integer.parseInt(request.getParameter("TotalNumberStudent")));
		classes.setIdFaculty(Integer.parseInt(request.getParameter("Faculty")));
		classes.setIdCourse(Integer.parseInt(request.getParameter("Course")));

		if (classesBo.updateClass(classes)) {
			response.sendRedirect(request.getContextPath() + "/ShowClasses?class=???");
		} else {
			Classes classes2 = classesBo.getClass(idClass);
			FacultyBo facultyBo = new FacultyBo();
			CoursesBo coursesBo = new CoursesBo();
			ArrayList<Faculty> listFaculty = facultyBo.getListFaculty();
			ArrayList<Courses> listCourse = coursesBo.getListCourses();

			request.setAttribute("class", classes2);
			request.setAttribute("listFaculty", listFaculty);
			request.setAttribute("listCourse", listCourse);
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/admin/ShowClassesEdit.jsp");
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
