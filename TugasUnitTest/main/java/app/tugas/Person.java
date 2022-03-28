package app.tugas;

import java.time.LocalDate;
import java.time.Period;

public class Person {
	private String name;
	private LocalDate birthdate;
	
	/**
	 * @param name
	 * @param birthdate YYYY-MM-DD
	 */
	public Person(String name, String birthdate) {
		this.name = name;
		this.birthdate = parseBirthdate(birthdate);
	}
	
	private LocalDate parseBirthdate(String birthdate) {
		int year = Integer.parseInt(birthdate.substring(0,4));
		int month = Integer.parseInt(birthdate.substring(5,7));
		int dayOfMonth = Integer.parseInt(birthdate.substring(8,10));
		return LocalDate.of(year,  month,  dayOfMonth);
	}
	
	public int getAge() {
		Period age = Period.between(birthdate, LocalDate.now());
		return age.getYears();
	}
	
	public boolean is17OrOlder() {
		return getAge() >= 17;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public LocalDate getBirthdate() {
		return birthdate;
	}
	
	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", birthdate=" + birthdate + "]";
	}
}
