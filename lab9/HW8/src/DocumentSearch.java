import java.util.*;

//Jarod England C343
public class DocumentSearch {
	HashTable a = new HashTable(); //the hashtable
	
	DocumentSearch(String file){ //creates the hash table to have the searches completed on it
		String tempWord = "";
		LinkedList words = new LinkedList();
		for (int i = 0; i<file.length(); i++){ //loops through all the characters in the file string
			if (file.substring(i, i+1).equals(" ") && i+1 < file.length()){ //checks to see if there is a space
				words.add(tempWord);
				tempWord = "";
			}
			else if (i+2<file.length() && file.substring(i, i+1).equals("\n") ){ //checks to see if there is a new line
				
				words.add(tempWord);
				tempWord = "";
				a.addLine(words);
				a.setSize(a.getSize()+1);
				LinkedList renew = new LinkedList();
				words = renew;
			}
			else{ //adds the new character in the iteration to the tempWord
				tempWord = tempWord + file.substring(i, i+1);
			}
		}
		
		words.add(tempWord);
		tempWord = "";              //does these commands one last time for the last linked list in the array
		a.addLine(words);
		a.setSize(a.getSize()+1);
		
	}
	
	public boolean llSearch(LinkedList a, String word){ //returns true or false depending on if the linkedList has the certain String
		return a.contains(word);
	}
	
	public void search(String word){ //searches for a word in the hash table and prints the lines found
		ArrayList<Integer> lines = new ArrayList<Integer>();
		
		for (int i = 0; i<a.getSize(); i++){
			if (llSearch(a.getLine(i),word)){
				lines.add(i+1);
			}
		}
		System.out.println(lines);
	}
	
	public static void main(String[] args){
		DocumentSearch words = new DocumentSearch("From WikiPedia\nIn computer science, a data structure is a particular way of storing and organizing data \nin a computer so that it can be used efficiently.\nDifferent kinds of data structures are suited to different kinds of applications, \nand some are highly specialized to specific tasks. For example, B-trees are particularly \nwell-suited for implementation of databases, while compiler implementations usually use hash \ntables to look up identifiers.\nData structures provide a means to manage large amounts of data efficiently, such as \nlarge databases and internet indexing services. Usually, efficient data structures \nare a key to designing efficient algorithms. Some formal design methods and programming languages \nemphasize data structures, rather than algorithms, as the key organizing factor in software design. \nStoring and retrieving can be carried out on data stored in both main memory and in secondary memory.");
		words.search("data");
	}
}
