package controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Account;
import model.bean.News;
import model.bo.AccountOfNewsBo;
import model.bo.NewsBo;

/**
 * Servlet implementation class DoNewsManageAddServlet
 */
@WebServlet("/DoNewsManageAdd")
public class DoNewsManageAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoNewsManageAddServlet() {
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
		Account account = (Account) session.getAttribute("account");
		String Title = request.getParameter("Title");
		String DescriptiveNews = request.getParameter("DescriptiveNews");
		String Detail = request.getParameter("Detail");
		int idCategory = Integer.parseInt(request.getParameter("Category"));
		NewsBo newsBo = new NewsBo();
		News news = new News();
		news.setTitle(Title);
		news.setDescriptiveNews(DescriptiveNews);
		news.setDetail(Detail);
		news.setIdCategory(idCategory);
		if (newsBo.addNews(news)) {
			int idNews = newsBo.getIdNewsCreated();
			AccountOfNewsBo accountOfNewsBo = new AccountOfNewsBo();
			if (accountOfNewsBo.addAccountOfNews(account.getIdAccount(), idNews)) {
				response.sendRedirect(request.getContextPath() + "/ShowNewsManage");
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/ShowNewsAdd");
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
