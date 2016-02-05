//a simple class for binary tree (mini-assignment)
public class BinNodeJr <E extends Comparable<?super E>>{ 
	private E value;
	private BinNodeJr<E> left;
	private BinNodeJr<E> right;
	public BinNodeJr(E e) {
		value = e;
		left = right = null;
	}
	public void setLeft(BinNodeJr<E> node) {
		left = node;
	}
	public void setRight(BinNodeJr<E> node) {
		right = node;
	}
	public boolean find(E q) {
		//System.out.println(q);
		if (value.compareTo(q) ==0){
			return true;
		}
		 if (left != null){
			 if (left.find(q)){
		    	return true;
		}}
		
		 if (right !=null){
			 if (right.find(q)){
			return true;
		}}
		
		return false;
	}
	
	public static void main(String[] argv) {
		BinNodeJr<Integer> root = new BinNodeJr<Integer>(25);
		BinNodeJr<Integer> node1 = new BinNodeJr<Integer>(30);
		root.setLeft(node1);
		BinNodeJr<Integer> node2 = new BinNodeJr<Integer>(40);
		root.setRight(node2);
		System.out.println(root.find(40));
		System.out.println(root.find(20));
		System.out.println(root.find(25));
		System.out.println(root.find(30));
		System.out.println(root.find(100));
		}
}