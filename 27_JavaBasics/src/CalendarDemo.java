import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar calendar = Calendar.getInstance();
		
		SimpleDateFormat s = new SimpleDateFormat("M/d/yyyy hh:mm:ss");
		System.out.println(s.format(calendar.getTime()));
		System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
		System.out.println(calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		System.out.println(calendar.get(Calendar.AM_PM));
		System.out.println(calendar.get(Calendar.MINUTE));
		
		
	}
}