package controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Account;
import model.bean.Decentralization;
import model.bo.AccountBo;
import model.bo.DecentralizationBo;

/**
 * Servlet implementation class DoAccountManagementServlet
 */
@WebServlet("/DoAccountManagement")
public class DoAccountManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoAccountManagementServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idAccount = Integer.parseInt(request.getParameter("idAccount"));
		String Username = request.getParameter("Username");
		String Email = request.getParameter("Email");
		int Decentralization = Integer.parseInt(request.getParameter("Decentralization"));

		AccountBo accountBo = new AccountBo();
		Account account = accountBo.getAccout(idAccount);

		account.setUsername(Username);
		account.setEmail(Email);
		account.setTypeAccount(Decentralization);
		if (accountBo.UpdateAccount(account)) {
			response.sendRedirect(request.getContextPath() + "/ShowAcountManagement");
		} else {
			Account account2 = accountBo.getAccout(idAccount);

			DecentralizationBo decentralizationBo = new DecentralizationBo();
			ArrayList<Decentralization> listDecentralization = decentralizationBo.getListDecentralization();

			request.setAttribute("account", account2);
			request.setAttribute("listDecentralization", listDecentralization);
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/admin/ShowAcountManagementEdit.jsp");
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
