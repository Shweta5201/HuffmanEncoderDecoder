import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HuffmanTree {

	Node root;
	HashMap<Integer, String> codeTable = new HashMap<Integer, String>();
	public void createHuffmanTree(FrequencyTable t) throws Exception {
		
		//PriorityQueue pq = new PairingHeap();
		//PriorityQueue pq = new BinaryHeap();
		PriorityQueue pq = new FourWayHeap();
		pq.create(t);
		//pq.printHeap();
		Node a, b;

		 while(pq.size()>4){
		//while (pq.size() > 1) {
			a = pq.removeMin();
			// System.out.println("min value a " + a.frequency);
			b = pq.removeMin();
			//System.out.println("min value a " + a.frequency + "min value b "
					//+ b.frequency);
			//System.out.println(pq.size() + "size");
			Node newParent = new Node(-1, a.frequency + b.frequency);
			newParent.left = a;
			newParent.right = b;
			// newParent.frequency=a.frequency+b.frequency;
			a.parent = newParent;
			b.parent = newParent;
			pq.insert(newParent);
		}
		//System.out.println(pq.size() + "size");
		root = pq.removeMin();
		//return root;
	//	Map<Integer, String> map = generateCode(root);
	//	System.out.println(map.size());
//		for (int key : map.keySet()) {
//
//			System.out
//					.println("data: " + key + " Code : " + map.get(key));
//		}

	}

	public Map<Integer, String> generateCode(Node root) {
	//	HashMap<Integer, String> codeTable = new HashMap<Integer, String>();
		if (root.left != null)
			traverse(root.left, codeTable, "0");
		if (root.right != null)
			traverse(root.right, codeTable, "1");
		return codeTable;

	}

	public void traverse(Node node, Map<Integer, String> codeTable,
			String prefix) {
		if (node.left == null && node.right == null) {
			codeTable.put(node.data, prefix.toString());
			return;
		}
		if (node.left != null) {
			traverse(node.left, codeTable, prefix + "0");
		}
		if (node.right != null) {
			traverse(node.right, codeTable, prefix + "1");
		}

	}
	
	
	public void writeCodeTable() throws IOException{
		FileWriter writer = new FileWriter(new File("code_table.txt"));
		Map<Integer, String> map=this.generateCode(root);
		Set<Integer> keyset = map.keySet();
		for (int key : keyset) {
			writer.write(key + " " + map.get(key) + "\n");
		}
		writer.flush();
		writer.close();
	}



}
