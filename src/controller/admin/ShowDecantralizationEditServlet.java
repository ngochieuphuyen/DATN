package controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Decentralization;
import model.bean.Function;
import model.bo.DecentralizationBo;
import model.bo.DecentralizationOfFunctionBo;
import model.bo.FunctionBo;

/**
 * Servlet implementation class ShowDecantralizationEditServlet
 */
@WebServlet("/ShowDecantralizationEdit")
public class ShowDecantralizationEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowDecantralizationEditServlet() {
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
			int idDecentralization = Integer.parseInt(request.getParameter("idDecantralization"));
			DecentralizationBo decentralizationBo = new DecentralizationBo();
			Decentralization decentralization2 = decentralizationBo.getDecentralization(idDecentralization);
			FunctionBo functionBo = new FunctionBo();
			ArrayList<Function> listFunction = functionBo.getListFunctionFull();
			DecentralizationOfFunctionBo decentralizationOfFunctionBo = new DecentralizationOfFunctionBo();
			ArrayList<Integer> listIdFunction = decentralizationOfFunctionBo.getListIdFunction(idDecentralization);
			request.setAttribute("decentralization", decentralization2);
			request.setAttribute("listFunction", listFunction);
			request.setAttribute("listIdFunction", listIdFunction);
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/admin/ShowDecentralizationEdit.jsp");
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
