package presenter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import model.*;
import view.IoManager;

public class Presenter {
	
	CyclingManager managerObj;
	IoManager console;
	
	public Presenter() {
		managerObj = new CyclingManager();
		console = new IoManager();
		addCyclists();	
		this.menu();
	}
	public void menu() {
        int op=0;
        do {
            op = console.readMenu();
            switch (op) {
              	case 1:
           		   addCyclist();
              	break;
               	case 2:
              	    managerObj.sortCyclistForTime();
               		console.showListDatas(managerObj.toMatrixVec());
           		break;
               	case 3:
            		managerObj.calculateFemaleAvarage();
               		managerObj.calculateMaleAvarage();
               	break;    
               	case 4:
              		console.showMessage((managerObj.bestGirlCyclist()));
          		break;  
                case 5:
                  	console.showMessage("Salida");
                break;
                default:
                    console.showMessage("Opcion invalida");
                }
        } while (op != 5);
    } 

	public void addCyclists() {
		managerObj.addCyclist(new Cyclist(1, "Jose", "Gomez", LocalDate.parse("1998-10-30"), Gender.MALE, Teams.MOVISTAR_TEAM, LocalTime.parse("01:01:01"), managerObj.determineAgeRange(LocalDate.parse("1998-10-30"))));
		managerObj.addCyclist(new Cyclist(2, "Juan", "Perez", LocalDate.parse("2004-11-02"), Gender.MALE, Teams.MONDIALE, LocalTime.parse("03:15:36"),managerObj.determineAgeRange(LocalDate.parse("2004-11-02"))));
		managerObj.addCyclist(new Cyclist(3, "Esteban", "Rodriguez", LocalDate.parse("2002-08-25"), Gender.MALE, Teams.ASTANA, LocalTime.parse("04:05:20"),managerObj.determineAgeRange(LocalDate.parse("2002-08-25"))));
		managerObj.addCyclist(new Cyclist(4, "Miguel", "Forero", LocalDate.parse("1994-07-15"), Gender.MALE, Teams.CCC_TEAM, LocalTime.parse("05:02:12"), managerObj.determineAgeRange(LocalDate.parse("1994-07-15"))));
		managerObj.addCyclist(new Cyclist(5, "Luis", "Henao", LocalDate.parse("1990-06-22"), Gender.MALE, Teams.TEAM_SKY, LocalTime.parse("04:40:11"), managerObj.determineAgeRange(LocalDate.parse("1994-07-15"))));
		managerObj.addCyclist(new Cyclist(6, "Gabriela", "Torres", LocalDate.parse("1988-05-18"), Gender.FEMALE, Teams.TEAM_DIMENSION, LocalTime.parse("05:22:23"),managerObj.determineAgeRange(LocalDate.parse("1999-04-17"))));
		managerObj.addCyclist(new Cyclist(7, "Felipe", "Carvajal", LocalDate.parse("1999-04-17"), Gender.MALE, Teams.TEAM_ARKEA, LocalTime.parse("04:11:03"),managerObj.determineAgeRange(LocalDate.parse("1999-04-17"))));
		managerObj.addCyclist(new Cyclist(8, "Angela", "Garcia", LocalDate.parse("2000-03-26"), Gender.FEMALE, Teams.TEAM_NOVO, LocalTime.parse("03:01:18"),managerObj.determineAgeRange(LocalDate.parse("2000-03-26"))));
		managerObj.addCyclist(new Cyclist(9, "Laura", "Torres", LocalDate.parse("2004-02-11"), Gender.FEMALE, Teams.CAJA_RURAL, LocalTime.parse("04:25:27"),managerObj.determineAgeRange(LocalDate.parse("2004-02-11"))));
		managerObj.addCyclist(new Cyclist(10, "Carolina", "Hernandez", LocalDate.parse("2003-01-05"), Gender.FEMALE, Teams.BURGOS, LocalTime.parse("04:10:35"),managerObj.determineAgeRange(LocalDate.parse("2003-01-05"))));
		managerObj.addCyclist(new Cyclist(11, "Juliana", "Gonzalez", LocalDate.parse("2001-10-27"), Gender.FEMALE, Teams.MOVISTAR_TEAM, LocalTime.parse("04:19:01"),managerObj.determineAgeRange(LocalDate.parse("2001-10-27"))));
		managerObj.addCyclist(new Cyclist(12, "Alex", "Romero", LocalDate.parse("1997-10-31"), Gender.MALE, Teams.MONDIALE, LocalTime.parse("05:22:09"),managerObj.determineAgeRange(LocalDate.parse("1997-10-31"))));
		managerObj.addCyclist(new Cyclist(13, "Daniela", "Perez", LocalDate.parse("1992-11-05"), Gender.FEMALE, Teams.ASTANA, LocalTime.parse("03:33:10"),managerObj.determineAgeRange(LocalDate.parse("1992-11-05"))));
		managerObj.addCyclist(new Cyclist(14, "Sebastian", "Celis", LocalDate.parse("1996-09-28"), Gender.MALE, Teams.TEAM_SKY, LocalTime.parse("05:11:38"),managerObj.determineAgeRange(LocalDate.parse("1996-09-28"))));
		managerObj.addCyclist(new Cyclist(15, "Nicolas", "Sierra", LocalDate.parse("1985-08-23"), Gender.MALE, Teams.TEAM_DIMENSION, LocalTime.parse("03:44:22"),managerObj.determineAgeRange(LocalDate.parse("1985-08-23"))));	
	}
	
	public void printCyclistList() {
		ArrayList<Cyclist> cyclistList = managerObj.getListCyclist();
		StringBuilder text = new StringBuilder();
		for (Cyclist cyclist : cyclistList) {
			text.append(cyclist);
			text.append("\n");
		}
		System.out.print(text.toString());
	}
	
	public Cyclist createCyclist() {
		LocalDate date = null;
		LocalTime time = null;
		int bibNumber = managerObj.getListCyclist().size()+1;
		String name = console.getCyclistName();
		String lastName = console.getCyclistLastName();
		date = console.getCyclistBirthDate();
		Gender gender = managerObj.selectGender(console.getCyclistGender());
		Teams team = managerObj.selectTeam(console.getCyclistTeam());
		time = LocalTime.parse(console.getTotalRaceTime());
		int age = managerObj.determineAgeRange(date);
		return new Cyclist(bibNumber, name, lastName, date, gender, team, time, age);
	}
	public void addCyclist() {
		Cyclist cyc = this.createCyclist();
		if (cyc.getAge()>15 && cyc.getAge()<40) {
			managerObj.addCyclist(cyc);
		}else {
			console.showMessageProblemAge();
		}
	}	   
}
