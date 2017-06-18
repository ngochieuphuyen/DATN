package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Account;
import model.bean.Function;
import model.bo.AccountBo;
import model.bo.FunctionBo;

/**
 * Servlet implementation class DoLoginServlet
 */
@WebServlet("/DoLogin")
public class DoLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String Username = request.getParameter("username");
		String Password = request.getParameter("password");
		AccountBo accountBo = new AccountBo();

		if (accountBo.isLogin(Username, Password)) {
			HttpSession session = request.getSession();
			Account account = accountBo.getAccountWithUsername(Username, Password);
			accountBo.setOnline(account.getIdAccount());
			session.setAttribute("account", account);
			FunctionBo functionBo = new FunctionBo();
			ArrayList<Function> listFunction = new ArrayList<>();
			switch (account.getTypeAccount()) {
			case 1:
				listFunction = functionBo.getListFunction(1);
				session.setAttribute("listFunction", listFunction);
				session.setAttribute("decentralization", "admin");
				response.sendRedirect(request.getContextPath() + "/ShowAcountManagement");
				break;
			case 2:
				listFunction = functionBo.getListFunction(2);
				session.setAttribute("listFunction", listFunction);
				session.setAttribute("decentralization", "user");
				response.sendRedirect(request.getContextPath() + "/ShowAccountInfor");
				break;
			}

		} else {
			response.sendRedirect("ShowLogin");
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
