import java.io.BufferedWriter;
import java.io.FileWriter;

public class WriteToOutputFile {
	
	private static String outputFileName;
	
	public WriteToOutputFile() {}
	
	public WriteToOutputFile(String outputFileName) {
		WriteToOutputFile.outputFileName = outputFileName;
	}

	public void write(String AvrageWaitingTimeInMin) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(getOutputFileName(), true))){
			bw.write(AvrageWaitingTimeInMin);
			bw.newLine();
		} catch (Exception e) {
			System.out.println("File for the output not found");
		}
	}

	public static String getOutputFileName() {
		return outputFileName;
	}
	
}
