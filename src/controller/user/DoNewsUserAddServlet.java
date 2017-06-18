package controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Account;
import model.bean.NewsOfUser;
import model.bo.NewsOfUserBo;

/**
 * Servlet implementation class DoNewsUserAddServlet
 */
@WebServlet("/DoNewsUserAdd")
public class DoNewsUserAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoNewsUserAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("account");
		String Title = request.getParameter("Title");
		String DescriptiveNews = request.getParameter("DescriptiveNews");
		String Detail = request.getParameter("Detail");
		int idCategory = Integer.parseInt(request.getParameter("Category"));
		NewsOfUserBo newsOfUserBo = new NewsOfUserBo();
		NewsOfUser newsOfUser = new NewsOfUser();
		
		newsOfUser.setTitle(Title);
		newsOfUser.setDescriptive(DescriptiveNews);
		newsOfUser.setDetail(Detail);
		newsOfUser.setIdCategory(idCategory);
		newsOfUser.setIdAccount(account.getIdAccount());
		if(newsOfUserBo.addNews(newsOfUser)){
			response.sendRedirect(request.getContextPath() + "/ShowPersonalInfor");
		} else {
			response.sendRedirect(request.getContextPath() + "/ShowAddNewsUser");
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
