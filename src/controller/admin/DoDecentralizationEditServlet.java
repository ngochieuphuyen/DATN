package controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.DecentralizationOfFunctionBo;
import model.bo.FunctionBo;

/**
 * Servlet implementation class DoDecentralizationEditServlet
 */
@WebServlet("/DoDecentralizationEdit")
public class DoDecentralizationEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoDecentralizationEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idDecentralization = Integer.parseInt(request.getParameter("idDecentralization"));
		FunctionBo functionBo = new FunctionBo();
		int amountFunction = functionBo.getListFunctionFull().size();
		ArrayList<Integer> listIdChecked = new ArrayList<>();
		for(int i =0;i<amountFunction;i++){
			if(request.getParameter("function"+i)!=null)
				listIdChecked.add(Integer.parseInt(request.getParameter("function"+i)));
		}
		DecentralizationOfFunctionBo decentralizationOfFunctionBo = new DecentralizationOfFunctionBo();
		if(decentralizationOfFunctionBo.upateFunction(idDecentralization, listIdChecked)){
			response.sendRedirect(request.getContextPath() + "/ShowDecentralization");
		}else {
			response.sendRedirect(request.getContextPath() + "/ShowDecantralizationEdit?idDecantralization="+idDecentralization);
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
