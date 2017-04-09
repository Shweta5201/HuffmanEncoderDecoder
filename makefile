JCC = javac

JFLAGS = -g

default: Node.class FrequencyTable.class PriorityQueue.class FourWayHeap.class HuffmanTree.class encoder.class decoder.class

Node.class: Node.java
	$(JCC) $(JFLAGS) Node.java
FrequencyTable.class: FrequencyTable.java
	$(JCC) $(JFLAGS) FrequencyTable.java
PriorityQueue.class: PriorityQueue.java
	$(JCC) $(JFLAGS) PriorityQueue.java
FourWayHeap.class: FourWayHeap.java
	$(JCC) $(JFLAGS) FourWayHeap.java
HuffmanTree.class: HuffmanTree.java
	$(JCC) $(JFLAGS) HuffmanTree.java
encoder.class: encoder.java
	$(JCC) $(JFLAGS) encoder.java
decoder.class: decoder.java
	$(JCC) $(JFLAGS) decoder.java

clean:
	$(RM) *.class
