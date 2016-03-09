import java.util.Arrays;

public class CountingSort {
	int[] CSort(int[] A){
		
	int m = findMax(A);
	
	
	//#first, count the number of records with each key value, save to c
	int[] c = new int[m];
	for (int i = 0; i < A.length; i++)
	     c[A[i]-1]++;
	//#c: array of accumulated counts
	for (int i = 1; i < m; i++)
	     c[i] += c[i-1];
	//#then, use the count information to place the items in order, saved to a new array
	int[] sorted = new int[A.length];
	for (int i = A.length-1; i >= 0; i--)
	     sorted[--c[A[i]-1]] = A[i];
		
		return sorted;
	}
	
	int findMax(int[] a){ //finds the max value in an array (m)
		int num = a[0];
		for (int i = 1; i<a.length ; i++){
			if(num< a[i]){
				num = a[i];
			}
		}
		return num;
	}
	
	
	public static void main(String[] args){
		int[] c = {42};
		int[] a = {3,4,2,2,1,1,5,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,7,7,7,7,7,7,7,7,7,7,7,2};
		CountingSort b = new CountingSort();
		System.out.println(Arrays.toString(b.CSort(a)));
		System.out.println(Arrays.toString(b.CSort(c)));
	}
}
