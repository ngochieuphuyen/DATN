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
import model.bo.NewsBo;

/**
 * Servlet implementation class ShowHomeServlet
 */
@WebServlet("/Home")
public class ShowHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowHomeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NewsBo newsBo = new NewsBo();
		ArrayList<News> listEvent = newsBo.getListEvent(5);
		ArrayList<News> listNotification = newsBo.getNotification(5);
		ArrayList<News> listScholarship = newsBo.getScholarship(5);
		ArrayList<News> listRecruitment = newsBo.getRecruitment(5);

		request.setAttribute("listEvent", listEvent);
		request.setAttribute("listNotification", listNotification);
		request.setAttribute("listScholarship", listScholarship);
		request.setAttribute("listRecruitment", listRecruitment);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/ShowHome.jsp");
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
