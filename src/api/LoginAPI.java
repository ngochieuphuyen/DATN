package api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.bean.Account;
import model.bo.AccountBo;

@Path("/login")
public class LoginAPI {

	@GET
	@Path("/check/{username}/{password}")
	@Produces(MediaType.TEXT_PLAIN)
	public String checkLogin(@PathParam("username") String username, @PathParam("password") String password,
			@Context HttpServletResponse servletResponse) throws IOException, ServletException {
		AccountBo accountBo = new AccountBo();
		if (accountBo.isLogin(username, password)) {
			Account account = accountBo.getAccountWithUsername(username, password);
			if ("User".equals(account.getDecentralizationName())){
				accountBo.setOnline(account.getIdAccount());
				return "true";
			}
		}
		return "false";
	}

	@GET
	@Path("/logout/{idAccount}")
	@Produces(MediaType.TEXT_PLAIN)
	public String offline(@PathParam("idAccount") int idAccount, @Context HttpServletResponse servletResponse)
			throws IOException, ServletException {
		AccountBo accountBo = new AccountBo();
		accountBo.setOffline(idAccount);
		return "true";
		
	}

	@GET
	@Path("/get/{username}/{password}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getAccount(@PathParam("username") String username, @PathParam("password") String password,
			@Context HttpServletResponse servletResponse) throws IOException, ServletException {
		AccountBo accountBo = new AccountBo();
		Account account = accountBo.getAccountWithUsername(username, password);
		String result = null;
		ObjectMapper om = new ObjectMapper();
		try {
			result = om.writerWithDefaultPrettyPrinter().writeValueAsString(account);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}

	@POST
	@Path("/test")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String test(@JsonFilter("ten") String ten, @Context HttpServletResponse servletResponse) throws IOException {
		// FacultyBo facultyBo = new FacultyBo();
		// ArrayList<Faculty> listFaculty = facultyBo.getListFaculty();
		// ObjectMapper om = new ObjectMapper();
		// String result = null;
		// try {
		// result =
		// om.writerWithDefaultPrettyPrinter().writeValueAsString(listFaculty);
		// } catch (JsonProcessingException e) {
		// e.printStackTrace();
		// }
		System.out.println(ten);
		// servletResponse.getWriter().append(result);
		return ten;
	}

}
