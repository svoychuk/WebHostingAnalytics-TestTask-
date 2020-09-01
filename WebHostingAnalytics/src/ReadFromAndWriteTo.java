

public class ReadFromAndWriteTo {

	public ReadFromAndWriteTo() {}
	
	public void startReadAndWrite(String sourceFile, String outputFile) {
		new ReadInput().startRead(sourceFile);
		new WriteToOutputFile(outputFile);
		DataBase.print();
		new Calculations().calculateAverageWaitingTime();	
		}

}
