import java.util.Date;

public class DataUnite {

	private String category;
	private String[] service;
	private String[] question;
	private String responseType;
	private Date responseDate;
	private int waitingTimeInMin;
	private Date dateFrom;
	private Date dateTo;
	
	private String service_id;
	private String variation_id;
	private String sub_variation_id;
	
	private String question_type_id;
	private String category_id;
	private String sub_category_id;
	
	public DataUnite(String category, String[] service, String[] question, String responseType) {
		this.category = category;
		this.service = service;
		this.question = question;
		this.responseType = responseType;
	}
	
	public DataUnite(String category, String[] service, String[] question, String responseType, Date responseDate, int waitingTimeInMin) {
		this(category, service, question, responseType);
		this.responseDate = responseDate;
		this.waitingTimeInMin = waitingTimeInMin;
	}
	
	public DataUnite(String category, String[] service, String[] question, String responseType, Date dateFrom, Date dateTo) {
		this(category, service, question, responseType);
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
	}

	public static String dataUniteInfo(DataUnite dU) {
		String service = dU.getService_id();
		if (dU.getVariation_id() != null) {
			service += "." + dU.getVariation_id();
			if (dU.getSub_variation_id() != null ) service += "." + dU.getSub_variation_id();
		}
		
		String question = "";
		if (dU.getQuestion_type_id() != null) {
			question += dU.getQuestion_type_id();
			if (dU.getCategory_id() != null) question += "." + dU.getCategory_id();
			if (dU.getSub_category_id() != null) question += "." + dU.getSub_category_id();	
		}
		else question = "*";
		
		switch (dU.getCategory()) {
			case("C"): {
				String[] uniteInfo = {dU.getCategory(), service, question, dU.getResponseType(), new StringDateConvertor().getStrDate(dU.getResponseDate()), String.valueOf(dU.getWaitingTimeInMin())};
				return String.join(",", uniteInfo);
			}
			case("D") : {
				if (dU.getDateTo() != null) {
				String[] uniteInfo = {dU.getCategory(), service, question, dU.getResponseType(), new StringDateConvertor().getStrDate(dU.getDateFrom()) + "-" + new StringDateConvertor().getStrDate(dU.getDateTo())};	
				return String.join(",", uniteInfo);
				}
				String[] uniteInfo = {dU.getCategory(), service, question, dU.getResponseType(), new StringDateConvertor().getStrDate(dU.getDateFrom())};	
				return String.join(",", uniteInfo);
			}
		}
		
		return "Nun";
	}
	
	public String getCategory() {
		return category;
	}

	public String[] getService() {
		return service;
	}

	public String[] getQuestion() {
		return question;
	}

	public String getResponseType() {
		return responseType;
	}

	public Date getResponseDate() {
		return responseDate;
	}

	public int getWaitingTimeInMin() {
		return waitingTimeInMin;
	}

	public String getService_id() {
		if (getService().length != 0) service_id = getService()[0];
		return service_id;
	}

	public String getVariation_id() {
		if (getService().length > 1) variation_id = getService()[1];
		return variation_id;
	}

	public String getSub_variation_id() {
		if (getService().length > 2) sub_variation_id = getService()[2];
		return sub_variation_id;
	}

	public String getQuestion_type_id() {
		if (getQuestion().length != 0) question_type_id = getQuestion()[0];
		return question_type_id;
	}

	public String getCategory_id() {
		if (getQuestion().length > 1) category_id = getQuestion()[1];
		return category_id;
	}

	public String getSub_category_id() {
		if (getQuestion().length > 2) sub_category_id = getQuestion()[2];
		return sub_category_id;
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}
	
}
