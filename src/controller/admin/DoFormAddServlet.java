package controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Form;
import model.bo.FormBo;

/**
 * Servlet implementation class DoFormAddServlet
 */
@WebServlet("/DoFormAdd")
public class DoFormAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoFormAddServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Form form = new Form();
		form.setFormName(request.getParameter("FormName"));
		form.setIdTypeOfForm(Integer.parseInt(request.getParameter("IdTypeOfForm")));
		form.setWaitingTime(Integer.parseInt(request.getParameter("WaitingTime")));
		form.setDescriptions(request.getParameter("Descriptions"));
		FormBo formBo = new FormBo();
		if (formBo.addForm(form)) {
			response.sendRedirect(request.getContextPath() + "/ShowFormManage");
		} else {
			response.sendRedirect(request.getContextPath() + "/ShowFormAdd");
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
