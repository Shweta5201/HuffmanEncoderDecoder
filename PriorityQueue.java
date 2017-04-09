import java.util.ArrayList;


public abstract class PriorityQueue {
	
	ArrayList<Node> heap;

	
	public PriorityQueue() {
		this.heap = new ArrayList<Node>();
	}
	public abstract Node removeMin() throws Exception;
	public abstract PriorityQueue create(FrequencyTable f);
	public abstract void insert(Node node);
	public int size() {
		
		return heap.size();
	}
	public void printHeap() {
		// TODO Auto-generated method stub
		
	}
}
