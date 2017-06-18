package controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Form;
import model.bean.TypeOfForm;
import model.bo.FormBo;
import model.bo.TypeOfFormBo;

/**
 * Servlet implementation class DoFormEditServlet
 */
@WebServlet("/DoFormEdit")
public class DoFormEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoFormEditServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idForm = Integer.parseInt(request.getParameter("idForm"));
		FormBo formBo = new FormBo();
		Form form = formBo.getForm(idForm);
		form.setFormName(request.getParameter("FormName"));
		form.setIdTypeOfForm(Integer.parseInt(request.getParameter("IdTypeOfForm")));
		form.setWaitingTime(Integer.parseInt(request.getParameter("WaitingTime")));
		form.setDescriptions(request.getParameter("Descriptions"));
		if (formBo.updateForm(form)) {
			response.sendRedirect(request.getContextPath() + "/ShowFormManage");
		} else {
			Form form2 = formBo.getForm(idForm);
			TypeOfFormBo typeOfFormBo = new TypeOfFormBo();
			ArrayList<TypeOfForm> listTypeOfForm = typeOfFormBo.getListTypeOfForm();
			request.setAttribute("form", form2);
			request.setAttribute("listTypeOfForm", listTypeOfForm);
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/admin/ShowFormEdit.jsp");
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
