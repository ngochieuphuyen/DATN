package model.bean;

import java.util.Date;

public class NewsOfUser {
	private int IdNewsOfUser;
	private int IdAccount;
	private int IdCategory;
	private String Title;
	private String Descriptive;
	private String Detail;
	private Date PostTime;
	
	
	public NewsOfUser(){}


	public int getIdNewsOfUser() {
		return IdNewsOfUser;
	}


	public void setIdNewsOfUser(int idNewsOfUser) {
		IdNewsOfUser = idNewsOfUser;
	}


	public int getIdAccount() {
		return IdAccount;
	}


	public void setIdAccount(int idAccount) {
		IdAccount = idAccount;
	}


	public int getIdCategory() {
		return IdCategory;
	}


	public void setIdCategory(int idCategory) {
		IdCategory = idCategory;
	}


	public String getTitle() {
		return Title;
	}


	public void setTitle(String title) {
		Title = title;
	}


	public String getDescriptive() {
		return Descriptive;
	}


	public void setDescriptive(String descriptive) {
		Descriptive = descriptive;
	}


	public String getDetail() {
		return Detail;
	}


	public void setDetail(String detail) {
		Detail = detail;
	}


	public Date getPostTime() {
		return PostTime;
	}


	public void setPostTime(Date postTime) {
		PostTime = postTime;
	};
	
}
