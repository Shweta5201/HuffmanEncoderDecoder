import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStream;





public class encoder {

	public void encode(File input, HuffmanTree tree) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader(input));
		
		OutputStream output = new BufferedOutputStream(new FileOutputStream ("encoded.bin"));
		String line, value;
		int lineValue;
		boolean[] bitset = new boolean[8];
		StringBuilder sb = new StringBuilder();
	
		while((line = br.readLine())!= null){
			if(!line.isEmpty()){
			lineValue = Integer.parseInt(line);
			value = tree.codeTable.get(lineValue);
			sb.append(value);
			while(sb.length()>=8){
				for(int j = 0; j<8 ; j++){
					if(sb.charAt(j)=='1'){
						bitset[j]= true;					
					}
					else{
						bitset[j]= false;
					}
				}
				sb= new StringBuilder(sb.substring(8));
				
				output.write(computeBytes(bitset));
		//	System.out.println(sb);
			}
		
			
			
		}
		}
		output.close();
		br.close();
		
	}
	
	
	public static int computeBytes(boolean[] bitArray) {
		if (bitArray == null || bitArray.length != 8) {
			throw new IllegalArgumentException();
		}
		int data = 0;
		for (int i = 0; i < 8; i++) {
			if (bitArray[i])
				data += (1 << (7 - i));
		}
		return data;
	}
	
	
	public static void main(String[] args) throws Exception {

		File input = new File(args[0]);
		//File input = new File("sample_input_large.txt");
		FrequencyTable table = new FrequencyTable();
		table.populateFrequencyTable(input);
		//double a = System.currentTimeMillis();
		HuffmanTree en = new HuffmanTree();
		en.createHuffmanTree(table);
		//System.out.println("Time for tree :" + (System.currentTimeMillis() - a));
		en.writeCodeTable();
		encoder encoder = new encoder(); 
		encoder.encode(input, en);
		//System.out.println("Time for encoding, creating tree and creating codetable :" +(System.currentTimeMillis() - a)/1000 + "seconds");

	}

}
