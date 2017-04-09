import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
//import java.util.Date;


public class decoder {

	static Node root=null;
	static Node next=null;
	//	static PriorityQueue h = new FourWayHeap();
	
	public static void main(String args[]) throws IOException{
	decode(args);
}


private static void decode(String args[]) throws IOException {
	//long startTime = System.currentTimeMillis();
	String encodedFile = args[0];
	String inputFile =args[1];
	FileInputStream in = new FileInputStream(inputFile);
	BufferedReader br = new BufferedReader(new InputStreamReader(in));
	String line = null;
	  
	while ((line = br.readLine()) != null && !line.isEmpty()) {
		String inputSplit[] = line.split(" ");
		int value =Integer.parseInt(inputSplit[0]);
		String code = inputSplit[1];
		createTrie(value, code);
	 
	}
	br.close();
	
	in.close();
	generateOutput(encodedFile);
	//long elapsedTime = (new Date()).getTime() - startTime;
    //System.out.println("Time for decoding :  " + elapsedTime/1000+ "seconds" );
	
    			
}


private static void createTrie(int value, String code) {
	Node curr;
	if(root==null){
		root = new Node();//created the root
	}
	curr=root;
	for(int i =0; i< code.length();i++){
		if(code.charAt(i)=='0'){
			if(curr.left!=null){
				curr=curr.left;
			}
			else{
				Node next = new Node();
				curr.left = next;
				curr=next;
			}
				
		}
		else{
			if(curr.right!=null){
				curr=curr.right;
			}
			else{
				Node next = new Node();
				curr.right = next;
				curr=next;
			}
				
		}
	}
	curr.data = value;
	curr.left=null;
	curr.right=null;	
}


private static void generateOutput(String encodedFilePath) throws IOException {
	
	File decodedFile = new File("decoded.txt");
 
	BufferedWriter output = new BufferedWriter(new FileWriter(decodedFile));
	File encodedFile = new File(encodedFilePath);
	byte[] decode = Files.readAllBytes(encodedFile.toPath());
	boolean[] bitset = new boolean[8];
	next=root;
	Node rootTemp=root;

	for(byte b :decode){
		for(int j=0;j<8;j++){
			if((b&(1<<(7-(j))))>0)
				bitset[j]=true;
			else
				bitset[j]= false;
			
		}
	
	for(int i=0; i< bitset.length;i++){
		if(!bitset[i]){
		rootTemp = rootTemp.left;
	}
	if(bitset[i]){
		rootTemp = rootTemp.right;
	}
	if(rootTemp.left == null && rootTemp.right == null){
		output.write(rootTemp.data+"\n");
		rootTemp=root;
		}
	
		}
	}
	

	output.close();

}

}

