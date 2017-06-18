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

import model.bean.Account;
import model.bean.AccountOfForm;
import model.bean.Form;
import model.bean.RegistrationSituation;
import model.bo.AccountOfFormBo;
import model.bo.FormBo;
import model.bo.RegistrationSituationBo;

/**
 * Servlet implementation class DoFormRegisterServlet
 */
@WebServlet("/DoFormRegister")
public class DoFormRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoFormRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("account");
		int idForm = Integer.parseInt(request.getParameter("idForm"));
		FormBo formBo = new FormBo();
		Form form = formBo.getForm(idForm);
		AccountOfForm accountOfForm = new AccountOfForm();
		accountOfForm.setIdAccount(account.getIdAccount());
		accountOfForm.setIdForm(form.getIdForm());
		accountOfForm.setIdSituation(Integer.parseInt(request.getParameter("IdSituation")));
		AccountOfFormBo accountOfFormBo = new AccountOfFormBo();
		if(accountOfFormBo.addAccountOfForm(accountOfForm, form.getWaitingTime())){
			response.sendRedirect(request.getContextPath() + "/ShowFormRequested");
		}else {
			Form form2 = formBo.getForm(idForm);
			RegistrationSituationBo registrationSituationBo = new RegistrationSituationBo();
			ArrayList<RegistrationSituation> listRegistrationSituation = registrationSituationBo
					.getListRegistrationSituation();
			request.setAttribute("form", form2);
			request.setAttribute("listRegistrationSituation", listRegistrationSituation);
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/user/ShowFormRegistration.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
