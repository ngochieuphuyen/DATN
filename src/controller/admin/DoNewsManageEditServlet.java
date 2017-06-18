package controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.News;
import model.bean.NewsCategory;
import model.bo.NewsBo;
import model.bo.NewsCategoryBo;

/**
 * Servlet implementation class DoNewsManageEditS?vlet
 */
@WebServlet("/DoNewsManageEdit")
public class DoNewsManageEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoNewsManageEditServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int IdNews = Integer.parseInt(request.getParameter("IdNews"));
		NewsBo newsBo = new NewsBo();
		News news = newsBo.getNews(IdNews);
		news.setTitle(request.getParameter("Title"));
		news.setDescriptiveNews(request.getParameter("DescriptiveNews"));
		news.setDetail(request.getParameter("Detail"));
		news.setIdCategory(Integer.parseInt(request.getParameter("Category")));
		if (newsBo.updateNews(news)) {
			response.sendRedirect(request.getContextPath() + "/ShowNewsManage");
		} else {
			News news2 = newsBo.getNews(IdNews);
			NewsCategoryBo newsCategoryBo = new NewsCategoryBo();
			ArrayList<NewsCategory> listCategories = newsCategoryBo.getListNewCategory();
			request.setAttribute("listCategories", listCategories);
			request.setAttribute("news", news2);
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/admin/ShowNewsEdit.jsp");
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
