package entities;

import java.util.Calendar;
import java.util.Date;

import entities.enums.Genre;
import entities.enums.Type;

public class Dependencie {
	private String name;
	private Genre genre;
	private Type type;
	private Date birthDate;
	
	public Dependencie(String name, Genre genre, Type type, Date birthDate) {
		this.name = name;
		this.genre = genre;
		this.type = type;
		this.birthDate = birthDate;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Genre getGenre() {
		return genre;
	}
	
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	public Type getType() {
		return type;
	}
	
	public void setType(Type type) {
		this.type = type;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	@Override
	public String toString() {
		Date today = new Date();
		Calendar todayCalendar = Calendar.getInstance();
		todayCalendar.setTime(today);
		
		Calendar birthDateCalendar = Calendar.getInstance();
		birthDateCalendar.setTime(birthDate);
		
		Calendar clone = (Calendar) birthDateCalendar.clone();
		int yearsOld = -1;
		while (!clone.after(todayCalendar)) {
			clone.add(Calendar.YEAR, 1);
			yearsOld++;
		}
		
		return "Name: " +
			name +
			" has " +
			yearsOld +
			" years old";
	}
}
