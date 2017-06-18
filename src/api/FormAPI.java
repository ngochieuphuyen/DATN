package api;

import java.io.IOException;
import java.util.ArrayList;

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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.bean.AccountOfForm;
import model.bean.Form;
import model.bean.RegistrationSituation;
import model.bo.AccountOfFormBo;
import model.bo.FormBo;
import model.bo.RegistrationSituationBo;

@Path("/form")
public class FormAPI {
	@GET
	@Path("/list/registration")
	@Produces(MediaType.TEXT_PLAIN)
	public String getListFormRegistration(@Context HttpServletResponse servletResponse)
			throws IOException, ServletException {
		RegistrationSituationBo registrationSituationBo = new RegistrationSituationBo();
		ArrayList<RegistrationSituation> listRegistrationSituation = registrationSituationBo
				.getListRegistrationSituation();
		String result = null;
		ObjectMapper om = new ObjectMapper();
		try {
			result = om.writerWithDefaultPrettyPrinter().writeValueAsString(listRegistrationSituation);
			// System.out.println(result);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}

	@GET
	@Path("/list")
	@Produces(MediaType.TEXT_PLAIN)
	public String getList(@Context HttpServletResponse servletResponse) throws IOException, ServletException {
		FormBo formBo = new FormBo();
		ArrayList<Form> listForm = formBo.getListForm();
		String result = null;
		ObjectMapper om = new ObjectMapper();
		try {
			result = om.writerWithDefaultPrettyPrinter().writeValueAsString(listForm);
			// System.out.println(result);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}

	@GET
	@Path("/requested/{idAccount}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getListFormRequested(@PathParam("idAccount") int idAccount,
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
	@Path("/register/{idAccount}/{idForm}")
	@Produces(MediaType.TEXT_PLAIN)
	public String register(@PathParam("idAccount") int idAccount, @PathParam("idForm") int idForm,
			@Context HttpServletResponse servletResponse) throws IOException, ServletException {
		FormBo formBo = new FormBo();
		Form form = formBo.getForm(idForm);
		AccountOfForm accountOfForm = new AccountOfForm();
		accountOfForm.setIdAccount(idAccount);
		accountOfForm.setIdForm(idForm);
		accountOfForm.setIdSituation(1);
		AccountOfFormBo accountOfFormBo = new AccountOfFormBo();
		if (accountOfFormBo.addAccountOfForm(accountOfForm, form.getWaitingTime())) {
			return "true";
		}

		return "false";
	}
}
