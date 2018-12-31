import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date = new Date();	
		SimpleDateFormat simple = new SimpleDateFormat("M/d/yyyy");
		SimpleDateFormat s = new SimpleDateFormat("M/d/yyyy hh:mm:ss");
		
		System.out.println(simple.format(date));
		System.out.println(s.format(date));
		System.out.println(date.toString());
	}
}