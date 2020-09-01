import java.util.ArrayList;
import java.util.List;

public class DataBase {
	
	private static List <DataUnite> dataBaseOfC = new ArrayList<>();
	private static List <DataUnite> dataBaseOfD = new ArrayList<>();
	
	public DataBase() {}

	public void add(DataUnite dataUnite) {
		if (dataUnite.getCategory().equals("C")) dataBaseOfC.add(dataUnite);
		else dataBaseOfD.add(dataUnite);
	}

	public List<DataUnite> getDataBaseOfD() {
		return dataBaseOfD;
	}

	public List<DataUnite> getDataBaseOfC() {
		return dataBaseOfC;
	}

	public static void print() {
		System.out.println();
		System.out.println("DataBase C.size " + dataBaseOfC.size());
		System.out.println("DataBase D.size " + dataBaseOfD.size());
		for (DataUnite dataUnite : dataBaseOfC) {
			System.out.println(DataUnite.dataUniteInfo(dataUnite));
		}
		for (DataUnite dataUnite : dataBaseOfD) {
			System.out.println(DataUnite.dataUniteInfo(dataUnite));
		}
		
	}
	
}
