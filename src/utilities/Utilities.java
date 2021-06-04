package utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import exception.*;

public class Utilities {
	
	public static final String FORMAT_DATE_ES = "d/M/yyyy";


	public static boolean validateReadName(String wordString) throws ExceptionReadName {
		Pattern pat = Pattern.compile("^[A-Z][a-z]+");
		Matcher mat = pat.matcher(wordString);
		if (mat.matches()) 
			return true;
		 else 
			throw new ExceptionReadName();
	}
	public static LocalDate toDate( String stringDate ) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern( FORMAT_DATE_ES );
		return LocalDate.parse( stringDate, dateTimeFormatter );
	}
	
	public static boolean validateDate( String dateString ) throws DateFormatException {
		Pattern pat = Pattern.compile("^(0?[1-9]|[12][0-9]|3[01])[\\/](0?[1-9]|1[012])[/\\\\/](19|20)\\d{2}$");
		Matcher mat = pat.matcher( dateString );
		if (mat.matches()){
			return true;
		} else {
			throw new DateFormatException();
		}
	}
}