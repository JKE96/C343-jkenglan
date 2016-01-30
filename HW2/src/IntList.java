
public class IntList implements List{
	private int size =0;
	int[] nums = new int[]{};
	
	public void makeSize(int size){ //creates the size of the IntList
		this.nums = new int[size];
		this.size = size;
	}
	
	public String toString(){ //converts the IntList to a String
		String s = new String("[");
		for (int i = 0; i<this.size; i++ ){
			if (i==0){
				s += this.nums[i];
			}
			else{
				s += "," + this.nums[i];
			}
		}
		return s +"]";
	}

	@Override
	public void insert(int num, int pos) { //inserts an int at a specified position
		this.nums[pos] = num;
	}

	@Override
	public boolean checkEmpty() { //checks if the IntList is empty
		return (this.size == 0);
	}

	@Override
	public void reinitialize() { //reinitializes the IntList
		this.nums = new int[]{};
		this.size = 0;
	}

	@Override
	public int howMany() { //returns the number of INTs currently in the list
		int count = 0;
		for (int i=0; i<this.size; i++){
			if((Integer)nums[i] instanceof Integer){
				count++;
			}
		}
		return count;
	}

	@Override
	public void delete(int pos) { //deletes the specified number and replaces it with 0
		this.nums[pos] = 0;
	}
}
