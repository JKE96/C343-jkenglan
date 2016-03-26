import java.util.ArrayList;
import java.util.LinkedList;

public class HashTable {  //I am making my own implementation 
	private int size = 0; //size of hashtable
	ArrayList<LinkedList<String>> b = new ArrayList<LinkedList<String>>(); //this is the arraylist of linkedList of Strings
	
	void addLine(LinkedList ll){
		b.add(ll);
	}

	LinkedList getLine(int num){ //Gets a line from the HashTable
		return b.get(num);
	}

	public int getSize() { //gets size of the hashtable
		return size;
	}

	public void setSize(int size) { //sets size of the hashtable
		this.size = size;
	}
	
	
}
