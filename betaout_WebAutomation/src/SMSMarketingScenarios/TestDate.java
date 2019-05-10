package SMSMarketingScenarios;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.testng.annotations.Test;

public class TestDate {

public static void main(String[] args) {
	DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	Date dateobj = new Date();
	String finalDate = df.format(dateobj);
	System.out.println("hii");
	System.out.println(finalDate);
		
}
		
/*	@Test
	public void compareTwoDates()
	{
	
		Date d1 = this.getCurrentDateTime();		
		System.out.println(d1 );	 
		
	}*/
	
	
}

