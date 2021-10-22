package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {
	private String name;
	private String email;
	private Date birthDate;
	private SimpleDateFormat sdf;
	
	public Client(String name, String email, Date birthDate, SimpleDateFormat sdf) {
		super();
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
		this.sdf = sdf;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String toString() {
		return name +
				" (" +
				sdf.format(birthDate) +
				") - " +
				email;
	}
}
