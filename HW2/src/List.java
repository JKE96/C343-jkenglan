
interface List {
	void insert(int num, int pos); //inserts an int at specified position
	boolean checkEmpty(); //checks if a list is empty
	void reinitialize(); //reinitializes the list
	int howMany(); //tells how many elements are in the list
	void delete(int pos); //deletes what is at the specified position
}
