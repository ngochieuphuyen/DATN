package controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.DecentralizationBo;

/**
 * Servlet implementation class DoDecentralizationAddServlet
 */
@WebServlet("/DoDecentralizationAdd")
public class DoDecentralizationAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoDecentralizationAddServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String DecentralizationName = request.getParameter("DecentralizationName");
		String Description = request.getParameter("Description");
		DecentralizationBo decentralizationBo = new DecentralizationBo();
		if (decentralizationBo.createDecentralization(DecentralizationName, Description)) {
			response.sendRedirect(request.getContextPath() + "/ShowDecentralization");
		} else {
			response.sendRedirect(request.getContextPath() + "/ShowDecentralizationAdd");
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
