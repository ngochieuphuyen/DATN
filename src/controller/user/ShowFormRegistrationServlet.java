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
import model.bean.RegistrationSituation;
import model.bo.FormBo;
import model.bo.RegistrationSituationBo;

/**
 * Servlet implementation class ShowFormRegistrationServlet
 */
@WebServlet("/ShowFormRegistration")
public class ShowFormRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowFormRegistrationServlet() {
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
			response.sendRedirect(request.getContextPath() + "/DoLogout");
		} else if ("user".equals(decentralization)) {
			int idForm = Integer.parseInt(request.getParameter("idForm"));
			FormBo formBo = new FormBo();
			Form form = formBo.getForm(idForm);
			RegistrationSituationBo registrationSituationBo = new RegistrationSituationBo();
			ArrayList<RegistrationSituation> listRegistrationSituation = registrationSituationBo
					.getListRegistrationSituation();
			request.setAttribute("form", form);
			request.setAttribute("listRegistrationSituation", listRegistrationSituation);
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/user/ShowFormRegistration.jsp");
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
