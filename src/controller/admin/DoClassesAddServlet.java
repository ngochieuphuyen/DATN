package controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Classes;
import model.bo.ClassesBo;

/**
 * Servlet implementation class DoClassesAddServlet
 */
@WebServlet("/DoClassesAdd")
public class DoClassesAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoClassesAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ClassName = request.getParameter("ClassName");
		int TotalNumberStudent = Integer.parseInt(request.getParameter("TotalNumberStudent"));
		int idFaculty = Integer.parseInt(request.getParameter("Faculty"));
		int idCourse = Integer.parseInt(request.getParameter("Course"));
		Classes classes = new Classes();
		classes.setClassName(ClassName);
		classes.setTotalNumberStudent(TotalNumberStudent);
		classes.setIdFaculty(idFaculty);
		classes.setIdCourse(idCourse);
		
		ClassesBo classesBo = new ClassesBo();
		if(classesBo.addClass(classes)){
			response.sendRedirect(request.getContextPath() + "/ShowClasses?class=???");
		}else {
			response.sendRedirect(request.getContextPath() + "/ShowClassesAdd");
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
