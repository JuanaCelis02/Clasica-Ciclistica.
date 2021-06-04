package model;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class CyclingManager {
	
	private ArrayList<Cyclist> listCyclist;
	private String nameRace;
	private String country;
	
	public CyclingManager() {
		this.listCyclist = new ArrayList<Cyclist>();
	}

	public ArrayList<Cyclist> getListCyclist() {
		return listCyclist;
	}

	public void setListCyclist(ArrayList<Cyclist> listCyclist) {
		this.listCyclist = listCyclist;
	}

	public String getNameRace() {
		return nameRace;
	}

	public void setNameRace(String nameRace) {
		this.nameRace = nameRace;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public void addCyclist(Cyclist cyclist) {
		if (determineAgeRange(cyclist.getBirthDate())>15 && determineAgeRange(cyclist.getBirthDate())<40) {
			listCyclist.add(cyclist);
		}
	}
	
	public int determineAgeRange(LocalDate birthDate) {
		int age = 0;
		LocalDate ahora = LocalDate.now();
		Period periodo = Period.between(birthDate, ahora);
		age = periodo.getYears();
		return age;
	}
	
	public void calculateGeneralAverage(Gender gender) {
		long seconds = 0;
		int count = 0;
		for (int i = 0; i < listCyclist.size(); i++) {
			if (listCyclist.get(i).getGender().equals(gender)) {
				seconds += listCyclist.get(i).getTotalRaceTime().getLong(ChronoField.SECOND_OF_DAY);
				count++;
			}
		}
		LocalTime timeOfDay = LocalTime.ofSecondOfDay(seconds/count);
		String time = timeOfDay.toString();
		System.out.println("Promedio "+ gender.getGenderName() + " "+time);
	}
	
	public void calculateFemaleAvarage() {
		calculateGeneralAverage(Gender.FEMALE);
	}
	public void calculateMaleAvarage() {
		calculateGeneralAverage(Gender.MALE);
	}
	
	public Gender selectGender(int  option) {
		Gender gender = null;
		switch (option) {
		case 1:
			gender = Gender.FEMALE;
			break;
		case 2:
			gender = Gender.MALE;
		default:
			System.out.println("Opcion invalida");
		break;
		}
		return gender;
	}
	public Teams selectTeam(int option) {
		Teams team = null;
		switch (option) {
		case 1:
			team = Teams.MOVISTAR_TEAM;
			break;
		case 2:
			team = Teams.MONDIALE;
			break;
		case 3:
			team = Teams.ASTANA;
			break;
		case 4:
			team = Teams.CCC_TEAM;
			break;
		case 5:
			team = Teams.TEAM_SKY;
			break;
		case 6:
			team = Teams.TEAM_DIMENSION;
			break;
		case 7:
			team = Teams.TEAM_ARKEA;
			break;
		case 8:
			team = Teams.TEAM_NOVO;
			break;
		case 9:
			team = Teams.CAJA_RURAL;
			break;
		case 10:
			team = Teams.BURGOS;
			break;

		default:
			System.out.println("Opcion invalida");
			break;
		}
		return team;
	}
	
	public String bestGirlCyclist() {
		String salida = "";
		sortCyclistForTime();
	   for (int i = 0; i < listCyclist.size(); i++) {
		   if (listCyclist.get(i).getGender().equals(Gender.FEMALE)) {
			salida = listCyclist.get(i).toString();
			break;
		   }
	   }
	   return salida;
	}
	
	public  Object[][] toMatrixVec(){
        Object[][] dataMatrix = null;
        int sizeColumns = listCyclist.get(0).toObjectVector().length;
        if (listCyclist.size() >0){
            dataMatrix = new Object[listCyclist.size()][sizeColumns];
            for (int i=0; i <dataMatrix.length;i++){
                dataMatrix[i] = listCyclist.get(i).toObjectVector();
            }
        }
        return dataMatrix;
    }
	
	public void sortCyclistForTime(){
		Collections.sort(listCyclist, new Comparator<Cyclist>(){
			public int compare(Cyclist c1, Cyclist c2) {
				if (c1.getTotalRaceTime().isAfter(c2.getTotalRaceTime())) {
					return 1;
				}else if (c1.getTotalRaceTime().equals(c2.getTotalRaceTime())) {
					return 0;
				}else {
					return -1;
				}
			}
			
		});
	}	
	
}
