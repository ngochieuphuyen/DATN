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

import model.bean.Decentralization;
import model.bo.DecentralizationBo;

/**
 * Servlet implementation class ShowDecentralizationServlet
 */
@WebServlet("/ShowDecentralization")
public class ShowDecentralizationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowDecentralizationServlet() {
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
			DecentralizationBo decentralizationBo = new DecentralizationBo();
			ArrayList<Decentralization> listDecentralization = decentralizationBo.getListDecentralization();

			request.setAttribute("listDecentralization", listDecentralization);
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/admin/ShowDecentralization.jsp");
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
