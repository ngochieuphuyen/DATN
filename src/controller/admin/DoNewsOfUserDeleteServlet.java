package controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.NewsOfUserBo;

/**
 * Servlet implementation class DoNewsOfUserDeleteServlet
 */
@WebServlet("/DoNewsOfUserDelete")
public class DoNewsOfUserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoNewsOfUserDeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idNewsOfUser = Integer.parseInt(request.getParameter("idNewsOfUser"));
		NewsOfUserBo newsOfUserBo = new NewsOfUserBo();
		newsOfUserBo.deleteNews(idNewsOfUser);

		response.sendRedirect(request.getContextPath() + "/ShowNewsAccept");
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
