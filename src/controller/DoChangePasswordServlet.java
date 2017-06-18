package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Account;
import model.bean.Decentralization;
import model.bo.AccountBo;
import model.bo.DecentralizationBo;

/**
 * Servlet implementation class DoChangePasswordServlet
 */
@WebServlet("/DoChangePassword")
public class DoChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoChangePasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idAccount = Integer.parseInt(request.getParameter("idAccount"));
		String password = request.getParameter("password");
		String newPassword = request.getParameter("newPassword");
		AccountBo accountBo = new AccountBo();
		Account account = accountBo.getAccout(idAccount);
		if (accountBo.ChangePassword(account, password, newPassword))
			account.setPassword(newPassword);
		HttpSession session = request.getSession();
		switch ((String)session.getAttribute("decentralization")) {
		case "user":
			response.sendRedirect(request.getContextPath() + "/ShowAccountInfor");
			break;

		default:
			DecentralizationBo decentralizationBo = new DecentralizationBo();
			ArrayList<Decentralization> listDecentralization = decentralizationBo.getListDecentralization();
			
			request.setAttribute("account", account);
			request.setAttribute("listDecentralization", listDecentralization);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/admin/ShowAcountManagementEdit.jsp");
			dispatcher.forward(request, response);
			break;
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
