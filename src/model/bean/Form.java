package model.bean;

public class Form {
	private int IdForm;
	private String FormName;
	private int IdTypeOfForm;
	private int WaitingTime;
	private String Descriptions;
	
	public Form(){}

	public Form(int idForm, String formName, int idTypeOfForm, int waitingTime, String descriptions) {
		super();
		IdForm = idForm;
		FormName = formName;
		IdTypeOfForm = idTypeOfForm;
		WaitingTime = waitingTime;
		Descriptions = descriptions;
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

	public int getIdTypeOfForm() {
		return IdTypeOfForm;
	}

	public void setIdTypeOfForm(int idTypeOfForm) {
		IdTypeOfForm = idTypeOfForm;
	}

	public int getWaitingTime() {
		return WaitingTime;
	}

	public void setWaitingTime(int waitingTime) {
		WaitingTime = waitingTime;
	}

	public String getDescriptions() {
		return Descriptions;
	}

	public void setDescriptions(String descriptions) {
		Descriptions = descriptions;
	}
	
}
