package controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.AccountOfFormBo;

/**
 * Servlet implementation class DoFormTimeoutServlet
 */
@WebServlet("/DoFormTimeout")
public class DoFormTimeoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoFormTimeoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idAccountOfForm = Integer.parseInt(request.getParameter("idAccountOfForm"));
		AccountOfFormBo accountOfFormBo = new AccountOfFormBo();
		accountOfFormBo.timeout(idAccountOfForm);
		
		response.sendRedirect(request.getContextPath() + "/ShowFormTimeout");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
