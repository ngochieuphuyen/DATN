package model.bean;

import java.util.Date;

public class AccountOfForm {
	private int IdAccountOfForm;
	private int IdForm;
	private String FormName;
	private int IdAccount;
	private String Username;
	private int IdSituation;
	private Date TimeOfRegistration;
	private Date ReceivingTime;

	public AccountOfForm() {
	}

	

	public String getUsername() {
		return Username;
	}



	public void setUsername(String username) {
		Username = username;
	}



	public int getIdAccountOfForm() {
		return IdAccountOfForm;
	}

	public void setIdAccountOfForm(int idAccountOfForm) {
		IdAccountOfForm = idAccountOfForm;
	}

	public int getIdForm() {
		return IdForm;
	}

	public void setIdForm(int idForm) {
		IdForm = idForm;
	}
	
	
	public String getFormName() {
		return FormName;
	}

	public void setFormName(String formName) {
		FormName = formName;
	}

	public int getIdAccount() {
		return IdAccount;
	}

	public void setIdAccount(int idAccount) {
		IdAccount = idAccount;
	}

	public int getIdSituation() {
		return IdSituation;
	}

	public void setIdSituation(int idSituation) {
		IdSituation = idSituation;
	}

	public Date getTimeOfRegistration() {
		return TimeOfRegistration;
	}

	public void setTimeOfRegistration(Date timeOfRegistration) {
		TimeOfRegistration = timeOfRegistration;
	}

	public Date getReceivingTime() {
		return ReceivingTime;
	}

	public void setReceivingTime(Date receivingTime) {
		ReceivingTime = receivingTime;
	}

}
