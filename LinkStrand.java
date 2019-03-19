public class LinkStrand implements IDnaStrand{

private class Node {
	String info;
	Node next;
	public Node (String s) {
		info = s;
		next = null;
}
}
	private Node myFirst, myLast;
	private long mySize;
	private int myAppends;
	private int myIndex;
	private int myLocalIndex;
	private Node myCurrent;
	/**
	* Default constructor for LinkStrand with an empty string
	* Just creates a LinkStrand object
	* @param none
	*/
	public LinkStrand() {
		this("");
	}
	/**
	 * Constructor for LinkStrand object with a String s
	 * Call to initialize to start the LinkedList
	 * @param String s of nucleotides
	 * @return none
	 */
	public LinkStrand(String s) {
		initialize(s);
	}
	/**
	 * Returns a type long variable that is the size
	 * of the LinkStrand object, which is essentiall the number
	 * of nucleotides
	 * @param none
	 * @return long mySize
	 */
@Override
	public long size() {
		return mySize;
	}

	/**
	 * Initializes a LinkStrand object with most
	 * instance variables equaling 0. mySize will equal the
	 * length of the parameter source
	 * @param String source that is the same as String s from the 
	 * LinkStrand constructor. Creates a new node in the LinkedList and assigns
	 * the first node to equal the last node.
	 * @return none. It just updates instance variables
	 */
@Override
	public void initialize(String source) {
		myFirst = new Node(source);
		mySize = source.length();
		myAppends = 0;
		myLast = myFirst;
		myIndex = 0;
		myLocalIndex = 0;
		myCurrent = myFirst;
}
	/**
	 * creates a LinkStrand object based on a String source
	 * Basically combines the initialize and LinkStrand constructor 
	 * in one method
	 * @param String source
	 * @return new LinkStrand object with the nucleotide sequence source
	 */
@Override
	public IDnaStrand getInstance(String source) {
		return new LinkStrand(source);
}

	/**
	 * Adds a new node to the LinkedList that contains
	 * the info in the parameter String dna
	 * changes myLast to myLast.next and myLast points to a new node
	 * Appends increases by 1
	 * mySize increases by the length of dna
	 * @param a sequence of dna 
	 * @return a LinkStrand object with the new node added
	 */
@Override
	public IDnaStrand append(String dna) {
		myLast.next = new Node(dna);
		myLast = myLast.next;
		myAppends++;
		mySize = mySize + dna.length();
		return this;
}
	/**
	 * getter method for the private variable myAppends
	 * @return the value of myAppends
	 */
@Override
	public int getAppendCount() {
		return myAppends;
	}
	/**
	 * Reverses the nodes in the LinkedList
	 * creates a copy of the LinkedList in StringBuilder
	 * then makes a new LinkStrand object and keeps making 
	 * the node point to the next string, which eventually 
	 * reverses the LinkedList
	 * @return the new reversed LinkedList
	 */
@Override
	public IDnaStrand reverse() {
		LinkStrand front = new LinkStrand();
		Node myF = myFirst;
		while(myF != null) {
			StringBuilder copy = new StringBuilder(myF.info);
			copy.reverse();
			String other = copy.toString();
			if (front == null) front = new LinkStrand(other);
			else {
				LinkStrand temp = new LinkStrand(other);
				while (front.myFirst != null) {
					temp.append(front.myFirst.info);
					front.myFirst = front.myFirst.next;
				}
				front = temp;
			}
			myF = myF.next;
		}
		return front;
}

	/**
	 * 
	 */
@Override
	public char charAt(int index) {
		if (index >= mySize|| index < 0 ) {
			throw new IndexOutOfBoundsException();
		}
	if (index < myIndex) {
		myIndex = 0;
		myLocalIndex = 0;
		myCurrent = myFirst;
	}
	while (myIndex != index) {
		myIndex++;
		myLocalIndex++;
		if (myLocalIndex >= myCurrent.info.length()) {
			myLocalIndex = 0;
			myCurrent = myCurrent.next;
		}
	}
        return myCurrent.info.charAt(myLocalIndex);
}

	/**
	 * Turns the LinkedList into a string by creating a new StringBuilder
	 * object, iterating through the LinkedList and appending the info 
	 * to the StringBuilder object
	 * @return a string by turning the StringBuilder object into a string
	 */
@Override
public String toString() {
	StringBuilder answer = new StringBuilder("");
	Node list = myFirst;
	while(list != null) {
		answer.append(list.info);
		list = list.next;
	}
	return answer.toString();
}
}

