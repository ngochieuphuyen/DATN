package controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Account;
import model.bean.News;
import model.bo.AccountBo;
import model.bo.AccountOfNewsBo;
import model.bo.NewsBo;

/**
 * Servlet implementation class ShowNewsManageDetailServlet
 */
@WebServlet("/ShowNewsManageDetail")
public class ShowNewsManageDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowNewsManageDetailServlet() {
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
			int idNews = Integer.parseInt(request.getParameter("idNews"));
			NewsBo newsBo = new NewsBo();
			News news = newsBo.getNewsDetail(idNews);
			AccountOfNewsBo accountOfNewsBo = new AccountOfNewsBo();
			int idAccount = accountOfNewsBo.getIdAccount(idNews);
			AccountBo accountBo = new AccountBo();
			Account account = accountBo.getAccout(idAccount);

			request.setAttribute("news", news);
			request.setAttribute("username", account.getUsername());
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/admin/ShowNewsManageDetail.jsp");
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
