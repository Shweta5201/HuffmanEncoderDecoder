import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;



public class FrequencyTable {
	public int[] fArray;

	public FrequencyTable() {
		fArray = new int[1000000];
	}	
	
	public void populateFrequencyTable(File input) throws Exception{
		//Scanner sc = new Scanner(new File("sample_input_large.txt"));
		FileReader f = new FileReader(input);
		BufferedReader br = new BufferedReader(f);
		String line;
		int lineValue;
		while((line = br.readLine())!= null){
			if(!line.isEmpty()){
			lineValue = Integer.parseInt(line);
			fArray[lineValue]++;
			}
		}
		br.close();
		
//		while (sc.hasNext()) {
//			int next = sc.nextInt();
//			fArray[next]++;
//		}
//		sc.close();
	}
}
