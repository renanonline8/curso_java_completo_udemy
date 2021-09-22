package application;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Main {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		Date d = new Date();
		
		System.out.println("Imprimir data atual");
		System.out.println(sdf.format(d));
		
		System.out.println("Diminuir um dia da data atual");
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.DAY_OF_MONTH, -1);
		d = cal.getTime();
		System.out.println(sdf.format(d));
		
		System.out.printf("Ontem foi dia %d do mês %d do ano de %d", 
			cal.get(Calendar.DAY_OF_MONTH) + 1, 
			cal.get(Calendar.MONTH) + 1,
			cal.get(Calendar.YEAR)
		);
	}

}
