package api;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.bean.Account;
import model.bean.AccountOfForm;
import model.bean.Student;
import model.bo.AccountBo;
import model.bo.AccountOfFormBo;
import model.bo.StudentsBo;

@Path("/personal")
public class PersonalAPI {
	@GET
	@Path("/infor/{idAccount}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getStudentWithAccount(@PathParam("idAccount") int idAccount,
			@Context HttpServletResponse servletResponse) throws IOException, ServletException {
		StudentsBo studentsBo = new StudentsBo();
		Student student = studentsBo.getStudentWithAccountDetail(idAccount);
		String result = null;
		ObjectMapper om = new ObjectMapper();
		try {
			result = om.writerWithDefaultPrettyPrinter().writeValueAsString(student);
			// System.out.println(result);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@GET
	@Path("/class/{idAccount}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getClassStudent(@PathParam("idAccount") int idAccount,
			@Context HttpServletResponse servletResponse) throws IOException, ServletException {
		StudentsBo studentsBo = new StudentsBo();
		Student student = studentsBo.getStudentWithAccountDetail(idAccount);
		int idClass = student.getIdClass();
		ArrayList<Student> listStudent = studentsBo.getListStudentsWithClass(String.valueOf(idClass));
		String result = null;
		ObjectMapper om = new ObjectMapper();
		try {
			result = om.writerWithDefaultPrettyPrinter().writeValueAsString(listStudent);
			// System.out.println(result);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@GET
	@Path("/student/{idStudent}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getFriend(@PathParam("idStudent") int idStudent,
			@Context HttpServletResponse servletResponse) throws IOException, ServletException {
		StudentsBo studentsBo = new StudentsBo();
		Student student = studentsBo.getStudent(idStudent);
		String result = null;
		ObjectMapper om = new ObjectMapper();
		try {
			result = om.writerWithDefaultPrettyPrinter().writeValueAsString(student);
			// System.out.println(result);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}

	@GET
	@Path("/requested/{idAccount}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getListFromRequested(@PathParam("idAccount") int idAccount,
			@Context HttpServletResponse servletResponse) throws IOException, ServletException {
		AccountOfFormBo accountOfFormBo = new AccountOfFormBo();
		ArrayList<AccountOfForm> listRequestedForm = accountOfFormBo.getListRequestedForm(idAccount);
		String result = null;
		ObjectMapper om = new ObjectMapper();
		try {
			result = om.writerWithDefaultPrettyPrinter().writeValueAsString(listRequestedForm);
			// System.out.println(result);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@GET
	@Path("/account/{idAccount}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getAccount(@PathParam("idAccount") int idAccount,
			@Context HttpServletResponse servletResponse) throws IOException, ServletException {
		AccountBo accountBo = new AccountBo();
		Account account = accountBo.getAccoutforAPI(idAccount);
		String result = null;
		ObjectMapper om = new ObjectMapper();
		try {
			result = om.writerWithDefaultPrettyPrinter().writeValueAsString(account);
			// System.out.println(result);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}

	@GET
	@Path("/changepass/{idAccount}/{newpass}")
	@Produces(MediaType.TEXT_PLAIN)
	public String changePassword(@PathParam("idAccount") int idAccount, @PathParam("newpass") String newpass) {
		AccountBo accountBo = new AccountBo();
		Account account = accountBo.getAccout(idAccount);
		if (accountBo.ChangePassword(account, account.getPassword(), newpass))
			return "true";

		return "false";
	}
	
	@GET
	@Path("/update/{idAccount}/{email}")
	@Produces(MediaType.TEXT_PLAIN)
	public String updateAccount(@PathParam("idAccount") int idAccount, @PathParam("email") String email) {
		AccountBo accountBo = new AccountBo();
		Account account = accountBo.getAccout(idAccount);
		account.setEmail(email);
		if (accountBo.UpdateAccount(account))
			return "true";

		return "false";
	}
}
