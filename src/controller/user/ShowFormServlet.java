package controller.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Form;
import model.bo.FormBo;

/**
 * Servlet implementation class ShowFormServlet
 */
@WebServlet("/ShowForm")
public class ShowFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowFormServlet() {
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
		if ("admin".equals(decentralization)) {
			response.sendRedirect(request.getContextPath() + "/ShowLogin");
		} else if ("user".equals(decentralization)) {
			FormBo formBo = new FormBo();
			ArrayList<Form> listForm = formBo.getListForm();

			request.setAttribute("listForm", listForm);
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/user/ShowForm.jsp");
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
