import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringDateConvertor {
	private String strDate;
	private Date date;
	
	public StringDateConvertor() {
	}

	public String getStrDate(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");  
		strDate = formatter.format(date);  
		return strDate;
	}
	
	public Date getDate(String strDate) {
		try {
			date = new SimpleDateFormat("dd.MM.yyyy").parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}


}