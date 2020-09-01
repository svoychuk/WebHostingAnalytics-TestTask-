import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class ReadInput {

	private DataBase db = new DataBase();
	
	public ReadInput() {}

	public void startRead(String sourceFile) {
		try (BufferedReader br = new BufferedReader(new FileReader(sourceFile))){
			String line;
			while ((line = br.readLine()) != null) {
				String category;
				String responseType;
				String[] service;
				String[] question;
				int waitingTimeInMin = 0;
				Date date = null;
				Date dateFrom = null;
				Date dateTo = null;
				
				if (line.startsWith("C") || line.startsWith("D")) {
					String[] c = line.split(" ");
					category = c[0].trim();
					responseType = c[3].trim();
					service = c[1].split("\\.");
					question = c[2].split("\\.");
					
					switch (category) {
					case ("C") : {
						date = new StringDateConvertor().getDate(c[4]);
						waitingTimeInMin = Integer.parseInt(c[5].trim());
						db.add(new DataUnite(category, service, question, responseType, date, waitingTimeInMin));
						break;
					}
					
					case ("D") : {
						if (c[4].contains("-")) {
							String[] d4 = c[4].split("-");
							dateFrom = new StringDateConvertor().getDate(d4[0]);
							dateTo = new StringDateConvertor().getDate(d4[1]);
						}
						else dateFrom = new StringDateConvertor().getDate(c[4]);
						
						db.add(new DataUnite(category, service, question, responseType, dateFrom, dateTo));
						break;
					}
					}
				} 
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("The source file is empty");
		}
	}
}