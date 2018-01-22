package br.com.servicosdebebidas.bean;

import javax.faces.bean.*;

import org.primefaces.context.RequestContext;

@ManagedBean(name = "login")
@SessionScoped
public class LoginBean {
	
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public LoginBean() {
		
	}
	
	public void login() {
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("swal('Login sucess!','Congratulation!')");
		
	}

}
