


public class Node implements Comparable{
	
	
	int data;
	int frequency;
	Node left;
	Node right;
	Node parent;
	
	Node leftChild;
	Node nextSibling;
	Node prev;
	
	
	public Node(int data, int frequency) {
		super();
		this.data = data;
		this.frequency = frequency;
	}


	public Node() {
		// TODO Auto-generated constructor stub
	}


	public int compareTo(Object obj) {
		Node o = (Node) obj;
		if(this.frequency == o.frequency){
			if(this.data == -1 && o.data!= -1 ){
				return -1;
				}
			else if (this.data != -1 && o.data== -1 )
				return 1;
			else if (this.data == -1 &&o.data == -1)
				return 0;
		}
		
		
		
		return -(this.frequency-o.frequency);
	}
	
	
}
