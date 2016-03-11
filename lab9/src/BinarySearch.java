
public class BinarySearch<E extends Comparable<?super E>>{

	//return the position of an element with value k in a sorted array
	//if k is not in A, return A.length
	int binaryFunction(E[] A, E val){
		int l = -1;
		int r = A.length;
		while(l+r != r){
			
			int i = (l+r)/2;
			if (val.compareTo(A[i]) == 0){
				return i;
			}
			else if(val.compareTo(A[i]) <= -1){
				r= i;
			}
			else{
				l = i;
			}
		}
		return A.length;
	}

	public static void main(String[] args){
		BinarySearch<Integer> bs = new BinarySearch<Integer>();
		Integer[] a = {9, 0,1,2,3,4,5,6};
		
		BinarySearch<String> ss = new BinarySearch<String>();
		String[] words = {"azure", "blue", "darkblue", "navyblue", "yellow"};
		
		System.out.println(bs.binaryFunction(a,5));
		System.out.println(ss.binaryFunction(words, "blue"));
	}
}
