import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Calculations {

	private static List<DataUnite> listD = new DataBase().getDataBaseOfD();
	private static List<DataUnite> listC = new DataBase().getDataBaseOfC();
	
	
	public void calculateAverageWaitingTime() {
		for (DataUnite dUD : listD) {
			String average = calulateAverage(filter(dUD));
			writeToOutput(average);
		}
	}

	private List<Integer> filter(DataUnite dUD) {
		List<Integer> arrayOfWaitingTimes = new ArrayList<>();
		
		for (DataUnite dUC : listC) {
			if (dUD.getService_id().equals(dUC.getService_id())){
				if (dUD.getQuestion_type_id().equals("*")
						|| dUD.getQuestion_type_id().equals(dUC.getQuestion_type_id())) {
					if (dateWithinRange(dUC.getResponseDate(), dUD.getDateFrom(), dUD.getDateTo())) {
						arrayOfWaitingTimes.add(dUC.getWaitingTimeInMin());
					}
				}
			}
		}
		return arrayOfWaitingTimes;
	}

	public boolean dateWithinRange(Date date, Date afterDate, Date beforeDate) {
		return date.after(afterDate) && date.before(beforeDate);
	}

	private String calulateAverage(List<Integer> arrayOfWaitingTimes) {
		if (arrayOfWaitingTimes.size() >= 1) {
			return arrayOfWaitingTimes.stream().mapToInt(a -> a).sum() / arrayOfWaitingTimes.size() + "";
		}
		return "-";
	}

	public void writeToOutput(String averageWaitingTimes) {
		new WriteToOutputFile().write(averageWaitingTimes);
	}
}
