package model.bean;

public class Account {
	private int IdAccount;
	private String Username;
	private String Password;
	private String Email;
	private int TypeAccount;
	private String DecentralizationName;
	private String Avatar;
	
	public Account(){
		IdAccount = -1;
		Username = null;
		Password = null;
		Email = null;
		TypeAccount = -1;
	}
	public Account(int idAccount, String username, String password, String email, int typeAccount) {
		IdAccount = idAccount;
		Username = username;
		Password = password;
		Email = email;
		TypeAccount = typeAccount;
	}
	public int getIdAccount() {
		return IdAccount;
	}
	public void setIdAccount(int idAccount) {
		IdAccount = idAccount;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getTypeAccount() {
		return TypeAccount;
	}
	public void setTypeAccount(int typeAccount) {
		TypeAccount = typeAccount;
	}
	
	public String getDecentralizationName() {
		return DecentralizationName;
	}
	public void setDecentralizationName(String decentralizationName) {
		DecentralizationName = decentralizationName;
	}
	public String getAvatar() {
		return Avatar;
	}
	public void setAvatar(String avatar) {
		Avatar = avatar;
	}
	
	
}
