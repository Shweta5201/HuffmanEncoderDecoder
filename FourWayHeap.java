import java.util.ArrayList;


public class FourWayHeap extends PriorityQueue{

	public FourWayHeap() {
		// int size = 0;
		heap = new ArrayList<Node>();
		for (int i = 0; i < 3; i++) {
			heap.add(new Node('\0','\0'));
			
		}
	}
	
	public int parent(int child) {
		int parent = (((child-3)-1) / 4)+3;
		return parent;
	}
	
	public void swap(int parent, int child) {
		Node temp = heap.get(parent);
		heap.set(parent, heap.get(child));
		heap.set(child, temp);
	}
	
	
	private void heapifyUp(int child) {

		Node temp = heap.get(child);
	//	System.out.println(temp.data);
		//System.out.println("child ["+temp.frequency+","+temp.data +" ]parent"+ parent(child));
		while (temp.frequency < heap.get(parent(child)).frequency && child >3) {
			//System.out.println("child ["+temp.frequency+","+temp.data +" ]parent"+ heap.get(parent(child)).frequency);
			swap(parent(child), child);
			child = parent(child);
			

		}
		temp = heap.get(child);
	}
	
	private void heapify(int index) {
		//index = index+3;
		int child1 = 4 * (index-2);
		int child2 = child1+1;
		int child3 = child2+1;
		int child4 = child3+1;
		int min = index;
		if ((child1 < heap.size())
				&& ((heap.get(child1).frequency < heap.get(min).frequency)
				|| (heap.get(child1).frequency == heap.get(min).frequency && heap.get(child1).data != -1))) {
			min = child1;
		}
		if (child2 < heap.size()
				&& (heap.get(child2).frequency < heap.get(min).frequency
				|| (heap.get(child2).frequency == heap.get(min).frequency && heap.get(child2).data != -1))) {
			min = child2;
		}
		
		if (child3 < heap.size()
				&& (heap.get(child3).frequency < heap.get(min).frequency
				|| (heap.get(child3).frequency == heap.get(min).frequency && heap.get(child3).data != -1))) {
			min = child3;
		}
		
		if ((child4 < heap.size())
				&& (heap.get(child4).frequency < heap.get(min).frequency
				|| (heap.get(child4).frequency == heap.get(min).frequency && heap.get(child4).data != -1))) {
			min = child4;
		}
		
		//if (child1 < heap.size() && heap.get(child1).frequency == heap.get(min).frequency && heap.get(child1).data != -1)
		//	min = left;

		if (min != index) {
			swap(min, index);
			heapify(min);

		}
		
	}
	
	@Override
	public Node removeMin() throws Exception {
		if (heap.size() < 4) {
			throw new Exception("Heap is empty");
		}
		int lastIndex = heap.size() - 1;
		Node min = heap.get(3);
		heap.set(3, heap.get(lastIndex));
		heap.remove(lastIndex);
		heapify(3);
		return min;		
	}

	@Override
	public PriorityQueue create(FrequencyTable f) {
		int[] table = f.fArray;
		
		for (int i = 0; i < table.length; i++) {
			if (table[i] != 0) {
				//System.out.println(table[i]);
				insert(new Node(i, table[i]));
				
			}
		}
		return this;
	}

	@Override
	public void insert(Node node) {
		//System.out.println(heap.size());
		heap.add(node);
		heapifyUp(heap.size() - 1);

		
	}
	
	
	public void printHeap() {
		System.out.print("\nHeap = ");
		for (int i = 3; i < heap.size(); i++)
			System.out.print("["+heap.get(i).data+": "+ heap.get(i).frequency+ "] ");
		System.out.println();
	}

}
