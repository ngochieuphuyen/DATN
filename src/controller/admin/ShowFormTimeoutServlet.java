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

import model.bean.AccountOfForm;
import model.bo.AccountOfFormBo;

/**
 * Servlet implementation class ShowFormTimeoutServlet
 */
@WebServlet("/ShowFormTimeout")
public class ShowFormTimeoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowFormTimeoutServlet() {
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
			AccountOfFormBo accountOfFormBo = new AccountOfFormBo();
			ArrayList<AccountOfForm> listTimeout = accountOfFormBo.getListTimeout();

			request.setAttribute("listTimeout", listTimeout);
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/admin/ShowFormTimeout.jsp");
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
