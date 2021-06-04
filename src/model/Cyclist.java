package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class Cyclist {
	
	private int bibNumber;
	private String name;
	private String lastName;
	private LocalDate birthDate;
	private Gender gender;
	private Teams team;
	private LocalTime totalRaceTime;
	private int age;
	
	public Cyclist() {
		
	}
	public Cyclist(int bibNumber, String name, String lastName, LocalDate birthDate, Gender gender, Teams team,
			LocalTime totalRaceTime, int age){
		this.bibNumber = bibNumber;
		this.name = name;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.gender = gender;
		this.team = team;
		this.totalRaceTime = totalRaceTime;
		this.age = age;
	}
	public int getBibNumber() {
		return bibNumber;
	}
	public void setBibNumber(int bibNumber) {
		this.bibNumber = bibNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Teams getTeam() {
		return team;
	}
	public void setTeam(Teams team) {
		this.team = team;
	}
	public LocalTime getTotalRaceTime() {
		return totalRaceTime;
	}
	public void setTotalRaceTime(LocalTime totalRaceTime) {
		this.totalRaceTime = totalRaceTime;
	}
	public int getAge() {
		return age;
	}
	public Object[] toObjectVector() {
        return new Object[] {getBibNumber(), getName(),getLastName(), getBirthDate(), gender.getGenderName(), team.getTeamName(),getTotalRaceTime(), getAge()};
    }
	
	@Override
	public String toString() {
		return "Numero del dorsal = " + bibNumber + ", Nombre = " + name + ", Apellido = " + lastName + ", Fecha de nacimiento = "
				+ birthDate + ", Genero =" + gender.getGenderName() + ", Equipo =" + team.getTeamName() + ", Tiempo total de recorrido =" + totalRaceTime + ", Edad ="
				+ getAge() + "\n";
	}
}
