package controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.FacultyBo;

/**
 * Servlet implementation class DoFacultyAddServlet
 */
@WebServlet("/DoFacultyAdd")
public class DoFacultyAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoFacultyAddServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String FacultyName = request.getParameter("FacultyName");
		FacultyBo facultyBo = new FacultyBo();
		if (facultyBo.addFaculty(FacultyName)) {
			response.sendRedirect(request.getContextPath() + "/ShowFaculty");
		} else {
			response.sendRedirect(request.getContextPath() + "/ShowFacultyAdd");
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
