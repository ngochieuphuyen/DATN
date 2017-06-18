package controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Faculty;
import model.bo.FacultyBo;

/**
 * Servlet implementation class DoFacultyEditServlet
 */
@WebServlet("/DoFacultyEdit")
public class DoFacultyEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoFacultyEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idFaculty = Integer.parseInt(request.getParameter("IdFaculty"));
		String FacultyName = request.getParameter("FacultyName");
		
		FacultyBo facultyBo = new FacultyBo();
		Faculty faculty = facultyBo.getFaculty(idFaculty);
		faculty.setFacultyName(FacultyName);
		
		if(facultyBo.updateFaculty(faculty)){
			response.sendRedirect(request.getContextPath() + "/ShowFaculty");
		}else {
			Faculty faculty2 = facultyBo.getFaculty(idFaculty);
			request.setAttribute("faculty", faculty2);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/admin/ShowFacultyEdit.jsp");
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
