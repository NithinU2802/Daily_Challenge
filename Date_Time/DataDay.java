import java.io.*;
import java.time.*;
import java.time.format.*;

class DateDay {
	public static void main(String[] args)
	{
		DateTimeFormatter myDateFormat
            = DateTimeFormatter.ofPattern(
                "EEEE, dd MMM yyyy");
        LocalDateTime date = LocalDateTime.now();
        String res = date.format(myDateFormat);
        System.out.println(res);
	}
}
