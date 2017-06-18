package controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Courses;
import model.bo.CoursesBo;

/**
 * Servlet implementation class ShowCourseEditServlet
 */
@WebServlet("/ShowCourseEdit")
public class ShowCourseEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCourseEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String decentralization = (String) session.getAttribute("decentralization");
		if ("user".equals(decentralization)) {
			response.sendRedirect(request.getContextPath() + "/DoLogout");
		} else if ("admin".equals(decentralization)) {
			CoursesBo coursesBo = new CoursesBo();
			int idCourse = Integer.parseInt(request.getParameter("idCourse"));
			Courses course = coursesBo.getCourse(idCourse);
			
			request.setAttribute("course", course);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/admin/ShowCourseEdit.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/ShowLogin");
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
