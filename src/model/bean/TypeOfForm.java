package model.bean;

public class TypeOfForm {
	private int IdTypeOfForm;
	private String TypeOfFormName;
	private String Desriptions;
	
	public TypeOfForm(){}

	public TypeOfForm(int idTypeOfForm, String typeOfFormName, String desriptions) {
		super();
		IdTypeOfForm = idTypeOfForm;
		TypeOfFormName = typeOfFormName;
		Desriptions = desriptions;
	}

	public int getIdTypeOfForm() {
		return IdTypeOfForm;
	}

	public void setIdTypeOfForm(int idTypeOfForm) {
		IdTypeOfForm = idTypeOfForm;
	}

	public String getTypeOfFormName() {
		return TypeOfFormName;
	}

	public void setTypeOfFormName(String typeOfFormName) {
		TypeOfFormName = typeOfFormName;
	}

	public String getDesriptions() {
		return Desriptions;
	}

	public void setDesriptions(String desriptions) {
		Desriptions = desriptions;
	}
	
}
