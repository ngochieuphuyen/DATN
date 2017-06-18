package controller;

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
 * Servlet implementation class ShowNewsWithCategoryServlet
 */
@WebServlet("/ShowNewsWithCategory")
public class ShowNewsWithCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowNewsWithCategoryServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idCategory = Integer.parseInt(request.getParameter("idCategory"));
		NewsBo newsBo = new NewsBo();
		ArrayList<News> listNewsWithCategory = newsBo.getListNewsWithCategory(idCategory, 20);
		ArrayList<News> listNewsHot = newsBo.getNewsHot(10);
		NewsCategoryBo newsCategoryBo = new NewsCategoryBo();
		NewsCategory newsCategory = newsCategoryBo.getNewsCategory(idCategory);
		request.setAttribute("listNewsWithCategory", listNewsWithCategory);
		request.setAttribute("listNewsHot", listNewsHot);
		request.setAttribute("newsCategory", newsCategory);
		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/ShowNewsWithCategory.jsp");
		dispatcher.forward(request, response);
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
