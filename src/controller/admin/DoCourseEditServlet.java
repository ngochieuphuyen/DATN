package controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Courses;
import model.bo.CoursesBo;

/**
 * Servlet implementation class DoCourseEditServlet
 */
@WebServlet("/DoCourseEdit")
public class DoCourseEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoCourseEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idCourse = Integer.parseInt(request.getParameter("IdCourse"));
		String courseName = request.getParameter("CourseName");
		CoursesBo coursesBo = new CoursesBo();
		Courses course = coursesBo.getCourse(idCourse);
		course.setCourseName(courseName);
		if(coursesBo.updateCourse(course)){
			response.sendRedirect(request.getContextPath() + "/ShowCourses");
		}else {
			Courses course2 = coursesBo.getCourse(idCourse);
			request.setAttribute("course", course2);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/admin/ShowCourseEdit.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
